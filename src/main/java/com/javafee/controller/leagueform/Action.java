package com.javafee.controller.leagueform;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javafee.dao.Team;
import com.javafee.leagueform.LeagueForm;

public class Action {
	private LeagueForm leagueForm;
	
	private ArrayList<Team> teams = new ArrayList<Team>();

	private String text1 = null;

	public void control() {
		initializeLeagueForm();
	}

	private void initializeLeagueForm() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leagueForm = new LeagueForm();
					leagueForm.setVisible(true);
					leagueForm.getBtnSaveTeams().addActionListener(e -> onClickBtnSaveTeams());
					leagueForm.getBtnGenerateCalendar().addActionListener(e -> onClickBtnGenerateCalendar());
					leagueForm.getBtnShowTeams().addActionListener(e -> onClickBtnShowTeams());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void onClickBtnSaveTeams() {
		if (!teams.isEmpty()) {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			for (Team team : teams) {
				session.save(team);

				System.out.println("Zapisano drużynę " + team.getName() + " do bazy!");
			}
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
		}
	}
	
	private void onClickBtnGenerateCalendar() {
		// pobranie drużyn i uzupełnienie listy teams
		onClickBtnCreateTeamObjects();
		if (text1 != null) {
			leagueForm.getEditorPane().setText(text1);
		} else if (!teams.isEmpty()) {
			ArrayList<String> findedTeamPairs = findPairs(teams);
			StringBuilder resultCalendar = new StringBuilder();
			for (String pair : findedTeamPairs)
				resultCalendar.append(pair + "\n");
			leagueForm.getEditorPane().setText(resultCalendar.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Nie wprowadzono drużyn", "Ostrzeżenie", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	private void onClickBtnShowTeams() {
		String text2 = null;
		if (leagueForm.getTextField().getText().isEmpty()) {
			text2 = "Nie wprowadzono pierwszej drużyny";
		} else if (leagueForm.getTextField_1().getText().isEmpty()) {
			text2 = "Nie wprowadzono drugiej drużyny";
		} else if (leagueForm.getTextField_2().getText().isEmpty()) {
			text2 = "Nie wprowadzono trzciej drużyny";
		} else if (leagueForm.getTextField_3().getText().isEmpty()) {
			text2 = "Nie wprowadzono czwartej drużyny";
		} else if (leagueForm.getTextField_4().getText().isEmpty()) {
			text2 = "Nie wprowadzono piątej drużyny";
		} else if (leagueForm.getTextField_5().getText().isEmpty()) {
			text2 = "Nie wprowadzono ostatniej drużyny";
		} else {
			text2 = leagueForm.getTextField().getText() + ", " + leagueForm.getTextField_1().getText() + ", " + leagueForm.getTextField_2().getText() + ", "
					+ leagueForm.getTextField_3().getText() + ", " + leagueForm.getTextField_4().getText() + ", " + leagueForm.getTextField_5().getText();
		}
		leagueForm.getEditorPane().setText(text2);
	}
	
	public void onClickBtnCreateTeamObjects() {
		createTeam(leagueForm.getTextField().getText());
		createTeam(leagueForm.getTextField_1().getText());
		createTeam(leagueForm.getTextField_2().getText());
		createTeam(leagueForm.getTextField_3().getText());
		createTeam(leagueForm.getTextField_4().getText());
		createTeam(leagueForm.getTextField_5().getText());
	}
	
	private Team createTeam(String teamName) {
		Team team = new Team();
		team.setName(teamName);
		if (!"".equals(teamName)) {
			teams.add(team);
		} else
			text1 = "Nie wprowadzono jednej z drużyn";
		return team;
	}
	
	public ArrayList<String> findPairs(ArrayList<Team> teams) {
		ArrayList<String> result = new ArrayList<String>();
		// algorytm
		for (Team team : teams) {

			for (Team foot_team : teams) {
				if (foot_team != team) {
					String pair = new String(foot_team.getName() + " vs " + team.getName());
					// dodanie par drużyn do listy wynikowej
					result.add(pair + "\n");
				}

			}
		}
		return result;
	}
}
