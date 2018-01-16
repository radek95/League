package com.javafee.controller.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javafee.dao.Game;
import com.javafee.dao.Team;

import antlr.StringUtils;

public class GameTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Game> games;
	private String[] column;

	public GameTableModel() {
		super();
		this.prepareHibernate();
		this.column = new String[] { "Team", "League", "Matches", "Points", "Goals"};
	}
	
	private void setGame(int index, Game game) {
		this.games.set(index, game);
	}
	
	private Game getGame(int index) {
		return this.games.get(index);
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		switch(column) {
		case 0:
			games.get(row).setTeam(value != null ? value.toString() : "");
		case 1:
			games.get(row).setLeague(value != null ? value.toString() : "");
		case 2:
			games.get(row).setMatches(value != null ? (Integer) value : null);
		case 3:
			games.get(row).setPoints(value != null ? (Integer) value : null);
		case 4:
			games.get(row).setGoals(value != null ? (Integer) value : null);
		}
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
		case 0:
			return games.get(row).getTeam();
		case 1:
			return games.get(row).getLeague();
		case 2:
			return games.get(row).getMatches();
		case 3:
			return games.get(row).getPoints();
		case 4:
			return games.get(row).getGoals();
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int index) {
		return this.column[index];
	}
	
	@Override
	public int getColumnCount() {
		return column.length;
	}
	
	public void refreshData() {
		this.fireTableDataChanged();
	}
	
	@SuppressWarnings({ "deprecation", "unchecked", "unused" })
	private void prepareHibernate() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		this.games = (ArrayList<Game>)session.createCriteria(Game.class).list();
		session.close();
		sessionFactory.close();
		
	}

	@Override
	public int getRowCount() {
		return games.size();
	}
}
