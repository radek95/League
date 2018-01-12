package com.javafee.controller.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javafee.dao.Team;

import antlr.StringUtils;

public class TeamTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Team> teams;
	private String[] column;

	public TeamTableModel() {
		super();
		this.prepareHibernate();
		this.column = new String[] { "Name", "Nationality", "Player quantity", "Coach" };
	}
	
	private void setTeam(int index, Team team) {
		this.teams.set(index, team);
	}
	
	private Team getTeam(int index) {
		return this.teams.get(index);
	}

	@Override
	public void setValueAt(Object value, int row, int column) {
		switch(column) {
		case 0:
			teams.get(row).setName(value != null ? value.toString() : "");
		case 1:
			teams.get(row).setNationality(value != null ? value.toString() : "");
		case 2:
			teams.get(row).setPlayersQuantity(value != null ? (Integer) value : null);
		case 3:
			teams.get(row).setCoach(value != null ? value.toString() : "");
		}
	}
	
	@Override
	public Object getValueAt(int row, int column) {
		switch(column) {
		case 0:
			return teams.get(row).getName();
		case 1:
			return teams.get(row).getNationality();
		case 2:
			return teams.get(row).getPlayersQuantity();
		case 3:
			return teams.get(row).getCoach();
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
		this.teams = (ArrayList<Team>)session.createCriteria(Team.class).list();
		session.close();
		sessionFactory.close();
		
	}

	@Override
	public int getRowCount() {
		return teams.size();
	}
}
