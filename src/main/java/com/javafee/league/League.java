package com.javafee.league;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class League extends JFrame {
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
	ArrayList<Team> teams = new ArrayList<Team>();
	String text1 = null;
	private JButton btnSaveTeams;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					League frame = new League();
					frame.addWindowListener(new WindowListener() {

						public void windowOpened(WindowEvent e) {
							List downloadedTeams = new List();
							// Pobranie rekordów z BD w postaci Listy
							// for(team)
							// downloadedTeams.add(team);
							// Jeśli lista niepusta przeiterować i dodać drużyny do
							// nowo dodanego TextFielda.
							// if (!teams.isEmpty()) {
							// for (String team : downloadedTeams)
							//
							// editorPane.setText(resultCalendar.toString());
							// } else {
							// JOptionPane.showMessageDialog(null, "Brak drużyn w bazie danych",
							// "Ostrzeżenie",
							// JOptionPane.WARNING_MESSAGE);
							// }
						}

						public void windowIconified(WindowEvent e) {
						}

						public void windowDeiconified(WindowEvent e) {
						}

						public void windowDeactivated(WindowEvent e) {
						}

						public void windowClosing(WindowEvent e) {
						}

						public void windowClosed(WindowEvent e) {
						}

						public void windowActivated(WindowEvent e) {
						}
					});
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public League() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 148, 164, 139, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JLabel lbTeam1 = new JLabel("Team 1");
		GridBagConstraints gbc_lbTeam1 = new GridBagConstraints();
		gbc_lbTeam1.insets = new Insets(0, 0, 5, 5);
		gbc_lbTeam1.anchor = GridBagConstraints.EAST;
		gbc_lbTeam1.gridx = 0;
		gbc_lbTeam1.gridy = 0;
		contentPane.add(lbTeam1, gbc_lbTeam1);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblTeam = new JLabel("Team 2");
		GridBagConstraints gbc_lblTeam = new GridBagConstraints();
		gbc_lblTeam.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam.anchor = GridBagConstraints.EAST;
		gbc_lblTeam.gridx = 0;
		gbc_lblTeam.gridy = 1;
		contentPane.add(lblTeam, gbc_lblTeam);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 3;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblTeam_1 = new JLabel("Team 3");
		GridBagConstraints gbc_lblTeam_1 = new GridBagConstraints();
		gbc_lblTeam_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_1.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_1.gridx = 0;
		gbc_lblTeam_1.gridy = 2;
		contentPane.add(lblTeam_1, gbc_lblTeam_1);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 3;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblTeam_2 = new JLabel("Team 4");
		GridBagConstraints gbc_lblTeam_2 = new GridBagConstraints();
		gbc_lblTeam_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_2.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_2.gridx = 0;
		gbc_lblTeam_2.gridy = 3;
		contentPane.add(lblTeam_2, gbc_lblTeam_2);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 3;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 3;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		lblTeam_3 = new JLabel("Team 5");
		GridBagConstraints gbc_lblTeam_3 = new GridBagConstraints();
		gbc_lblTeam_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_3.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_3.gridx = 0;
		gbc_lblTeam_3.gridy = 4;
		contentPane.add(lblTeam_3, gbc_lblTeam_3);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 4;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		lblTeam_4 = new JLabel("Team 6");
		GridBagConstraints gbc_lblTeam_4 = new GridBagConstraints();
		gbc_lblTeam_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeam_4.anchor = GridBagConstraints.EAST;
		gbc_lblTeam_4.gridx = 0;
		gbc_lblTeam_4.gridy = 5;
		contentPane.add(lblTeam_4, gbc_lblTeam_4);

		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 5;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("Show the teams");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickBtnNewButton();
			}
		});

		btnSaveTeams = new JButton("Save teams");
		btnSaveTeams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onClickBtnSave();
			}
		});
		GridBagConstraints gbc_btnSaveTeams = new GridBagConstraints();
		gbc_btnSaveTeams.insets = new Insets(0, 0, 5, 5);
		gbc_btnSaveTeams.gridx = 2;
		gbc_btnSaveTeams.gridy = 6;
		contentPane.add(btnSaveTeams, gbc_btnSaveTeams);

		btnGenerateCalendar = new JButton("Show the calendar");
		GridBagConstraints gbc_btnGenerateCalendar = new GridBagConstraints();
		gbc_btnGenerateCalendar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGenerateCalendar.gridx = 3;
		gbc_btnGenerateCalendar.gridy = 6;
		contentPane.add(btnGenerateCalendar, gbc_btnGenerateCalendar);
		btnGenerateCalendar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				onClickBtnGenerateCalendar();

			}

		});

		editorPane = new JEditorPane();
		GridBagConstraints gbc_editorPane = new GridBagConstraints();
		gbc_editorPane.gridheight = 2;
		gbc_editorPane.gridwidth = 4;
		gbc_editorPane.fill = GridBagConstraints.BOTH;
		gbc_editorPane.gridx = 0;
		gbc_editorPane.gridy = 7;
		contentPane.add(editorPane, gbc_editorPane);
	}

	private void onClickBtnNewButton() {
		String text2 = null;
		if (textField.getText().isEmpty()) {
			text2 = "Nie wprowadzono pierwszej drużyny";
		} else if (textField_1.getText().isEmpty()) {
			text2 = "Nie wprowadzono drugiej drużyny";
		} else if (textField_2.getText().isEmpty()) {
			text2 = "Nie wprowadzono trzciej drużyny";
		} else if (textField_3.getText().isEmpty()) {
			text2 = "Nie wprowadzono czwartej drużyny";
		} else if (textField_4.getText().isEmpty()) {
			text2 = "Nie wprowadzono piątej drużyny";
		} else if (textField_5.getText().isEmpty()) {
			text2 = "Nie wprowadzono ostatniej drużyny";
		} else {
			text2 = textField.getText() + ", " + textField_1.getText() + ", " + textField_2.getText() + ", "
					+ textField_3.getText() + ", " + textField_4.getText() + ", " + textField_5.getText();
		}
		editorPane.setText(text2);
	}

	private void onClickBtnGenerateCalendar() {
		// pobranie drużyn i uzupełnienie listy teams
		onClickBtnCreateTeamObjects();
		if (text1 != null) {
			editorPane.setText(text1);
		} else if (!teams.isEmpty()) {
			ArrayList<String> findedTeamPairs = findPairs(teams);
			StringBuilder resultCalendar = new StringBuilder();
			for (String pair : findedTeamPairs)
				resultCalendar.append(pair + "\n");
			editorPane.setText(resultCalendar.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Nie wprowadzono drużyn", "Ostrzeżenie", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void onClickBtnCreateTeamObjects() {
		createTeam(textField.getText());
		createTeam(textField_1.getText());
		createTeam(textField_2.getText());
		createTeam(textField_3.getText());
		createTeam(textField_4.getText());
		createTeam(textField_5.getText());
	}

	private void onClickBtnSave() {
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

	// dr1 vs. dr2
	// dr1 vs. dr3
	// dr2 vs. dr3
}
