package com.javafee.leagueform;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.javafee.controller.model.GameTableModel;
import com.javafee.controller.model.TeamTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LeagueForm extends JFrame {
	private static final long serialVersionUID = 6463445752669790332L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblTeam_3;
	private JLabel lblTeam_4;
	private JEditorPane editorPane;
	private JButton btnGenerateCalendar;
	private JButton btnSaveTeams;
	private JButton btnShowTeams;
	private JLabel lblHelloGit;
	private JComboBox comboBoxTeam;
	private JButton btnTest;
	private JScrollPane scrollPane_tableLeague;
	private JTable tableLeague;
	private JScrollPane scrollPane_tableGames;
	private JTable tableGame;
	

	/**
	 * Create the frame.
	 */
	public LeagueForm() {
		Utils.setLookAndFeel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1014, 624);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 58, 148, 164, 196, 405, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
		lblHelloGit = new JLabel("Czym byłoby zycie bez GIT'a?");
		GridBagConstraints gbc_lblHelloGit = new GridBagConstraints();
		gbc_lblHelloGit.gridwidth = 3;
		gbc_lblHelloGit.insets = new Insets(0, 0, 5, 5);
		gbc_lblHelloGit.gridx = 1;
		gbc_lblHelloGit.gridy = 0;
		contentPane.add(lblHelloGit, gbc_lblHelloGit);
		
		comboBoxTeam = new JComboBox();
		comboBoxTeam.setModel(new DefaultComboBoxModel(new String[] {"Bundesliga", "Champions League", "Ekstraklasa", "European League", "Ligue1", "Primiera Division", "Premier League", "Serie A"}));
		GridBagConstraints gbc_JComboBoxLeage = new GridBagConstraints();
		gbc_JComboBoxLeage.gridwidth = 3;
		gbc_JComboBoxLeage.insets = new Insets(0, 0, 5, 5);
		gbc_JComboBoxLeage.fill = GridBagConstraints.HORIZONTAL;
		gbc_JComboBoxLeage.gridx = 1;
		gbc_JComboBoxLeage.gridy = 1;
		contentPane.add(comboBoxTeam, gbc_JComboBoxLeage);
		
		scrollPane_tableLeague = new JScrollPane();
		GridBagConstraints gbc_scrollPane_tableLeague = new GridBagConstraints();
		gbc_scrollPane_tableLeague.gridheight = 7;
		gbc_scrollPane_tableLeague.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_tableLeague.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_tableLeague.gridx = 4;
		gbc_scrollPane_tableLeague.gridy = 1;
		contentPane.add(scrollPane_tableLeague, gbc_scrollPane_tableLeague);
		
		tableLeague = new JTable();
		tableLeague.setModel(new TeamTableModel());
		scrollPane_tableLeague.setViewportView(tableLeague);

		JLabel lbTeam1 = new JLabel("Team 1");
		GridBagConstraints gbc_lbTeam1 = new GridBagConstraints();
		gbc_lbTeam1.insets = new Insets(0, 0, 5, 5);
		gbc_lbTeam1.anchor = GridBagConstraints.EAST;
		gbc_lbTeam1.gridx = 0;
		gbc_lbTeam1.gridy = 2;
		contentPane.add(lbTeam1, gbc_lbTeam1);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblTeam = new JLabel("Team 2");
		GridBagConstraints gbc_lblTeam = new GridBagConstraints();
		gbc_lblTeam.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam.anchor = GridBagConstraints.EAST;
		gbc_lblTeam.gridx = 0;
		gbc_lblTeam.gridy = 3;
		contentPane.add(lblTeam, gbc_lblTeam);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblTeam_1 = new JLabel("Team 3");
		GridBagConstraints gbc_lblTeam_1 = new GridBagConstraints();
		gbc_lblTeam_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_1.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_1.gridx = 0;
		gbc_lblTeam_1.gridy = 4;
		contentPane.add(lblTeam_1, gbc_lblTeam_1);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblTeam_2 = new JLabel("Team 4");
		GridBagConstraints gbc_lblTeam_2 = new GridBagConstraints();
		gbc_lblTeam_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_2.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_2.gridx = 0;
		gbc_lblTeam_2.gridy = 5;
		contentPane.add(lblTeam_2, gbc_lblTeam_2);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 5;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		lblTeam_3 = new JLabel("Team 5");
		GridBagConstraints gbc_lblTeam_3 = new GridBagConstraints();
		gbc_lblTeam_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_3.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_3.gridx = 0;
		gbc_lblTeam_3.gridy = 6;
		contentPane.add(lblTeam_3, gbc_lblTeam_3);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 6;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		lblTeam_4 = new JLabel("Team 6");
		GridBagConstraints gbc_lblTeam_4 = new GridBagConstraints();
		gbc_lblTeam_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_4.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_4.gridx = 0;
		gbc_lblTeam_4.gridy = 7;
		contentPane.add(lblTeam_4, gbc_lblTeam_4);

		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 7;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

		btnShowTeams = new JButton("Show the teams");
		GridBagConstraints gbc_btnShowTeams = new GridBagConstraints();
		gbc_btnShowTeams.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowTeams.gridx = 1;
		gbc_btnShowTeams.gridy = 8;
		contentPane.add(btnShowTeams, gbc_btnShowTeams);

		btnSaveTeams = new JButton("Save teams");
		GridBagConstraints gbc_btnSaveTeams = new GridBagConstraints();
		gbc_btnSaveTeams.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveTeams.gridx = 2;
		gbc_btnSaveTeams.gridy = 8;
		contentPane.add(btnSaveTeams, gbc_btnSaveTeams);

		btnGenerateCalendar = new JButton("Show the calendar");
		btnGenerateCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnGenerateCalendar = new GridBagConstraints();
		gbc_btnGenerateCalendar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateCalendar.gridx = 3;
		gbc_btnGenerateCalendar.gridy = 8;
		contentPane.add(btnGenerateCalendar, gbc_btnGenerateCalendar);
		
		btnTest = new JButton("Initialize hibernate");
		GridBagConstraints gbc_btnTest = new GridBagConstraints();
		gbc_btnTest.insets = new Insets(0, 0, 5, 0);
		gbc_btnTest.gridx = 4;
		gbc_btnTest.gridy = 8;
		contentPane.add(btnTest, gbc_btnTest);

		editorPane = new JEditorPane();
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.insets = new Insets(0, 0, 0, 5);
		gbc_editorPane.gridheight = 2;
		gbc_editorPane.gridwidth = 4;
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.gridx = 0;
		gbc_editorPane.gridy = 9;
		contentPane.add(editorPane, gbc_editorPane);
		
		scrollPane_tableGames = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 9;
		contentPane.add(scrollPane_tableGames, gbc_scrollPane_1);
		
		tableGame = new JTable();
		tableGame.setModel(new GameTableModel());
		scrollPane_tableGames.setViewportView(tableGame);
	}
	
	public JComboBox getjComboBoxLeage() {
		return comboBoxTeam;
	}
	
	public JButton getBtnSaveTeams() {
		return btnSaveTeams;
	}
	
	public JButton getBtnGenerateCalendar() {
		return btnGenerateCalendar;
	}
	
	public JButton getBtnShowTeams() {
		return btnShowTeams;
	}
	
	public JComboBox getJComboBoxLeage() {
		return comboBoxTeam;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}

	public JButton getBtnTest() {
		return btnTest;
	}
}
