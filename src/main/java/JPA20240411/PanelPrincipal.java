package JPA20240411;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import JPA20240411.controladores.MateriaControlador;
import JPA20240411.controladores.ProfesorControlador;
import JPA20240411.model.Materia;
import JPA20240411.model.Profesor;
import JPA20240411.model.ValoracionMateria;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PanelPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<Materia> comboBoxMateria;
	private JComboBox<Profesor> comboBoxProfesor;
	private JComboBox<ValoracionMateria> comboBoxNota;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal frame = new PanelPrincipal();
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
	public PanelPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 149, 174, 73, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 192));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 76, 376, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblMateria = new JLabel("Materia :");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.WEST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		panel.add(lblMateria, gbc_lblMateria);

		comboBoxMateria = new JComboBox();
		GridBagConstraints gbc_comboBoxMateria = new GridBagConstraints();
		gbc_comboBoxMateria.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxMateria.gridx = 1;
		gbc_comboBoxMateria.gridy = 0;
		panel.add(comboBoxMateria, gbc_comboBoxMateria);
		cargarMateria();

		JLabel lblProfesor = new JLabel("Profesor :");
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.anchor = GridBagConstraints.WEST;
		gbc_lblProfesor.gridx = 0;
		gbc_lblProfesor.gridy = 1;
		panel.add(lblProfesor, gbc_lblProfesor);

		comboBoxProfesor = new JComboBox();
		GridBagConstraints gbc_comboBoxProfesor = new GridBagConstraints();
		gbc_comboBoxProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxProfesor.gridx = 1;
		gbc_comboBoxProfesor.gridy = 1;
		panel.add(comboBoxProfesor, gbc_comboBoxProfesor);

		JLabel lblNota = new JLabel("Nota :");
		GridBagConstraints gbc_lblNota = new GridBagConstraints();
		gbc_lblNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblNota.anchor = GridBagConstraints.WEST;
		gbc_lblNota.gridx = 0;
		gbc_lblNota.gridy = 2;
		panel.add(lblNota, gbc_lblNota);

		comboBoxNota = new JComboBox();
		GridBagConstraints gbc_comboBoxNota = new GridBagConstraints();
		gbc_comboBoxNota.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxNota.gridx = 1;
		gbc_comboBoxNota.gridy = 2;
		panel.add(comboBoxNota, gbc_comboBoxNota);

		JButton btnActualizar = new JButton("Boton actualizar alumnado");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarListaDeAlumnos();
			}
		});
		GridBagConstraints gbc_btnActualizar = new GridBagConstraints();
		gbc_btnActualizar.anchor = GridBagConstraints.EAST;
		gbc_btnActualizar.gridx = 1;
		gbc_btnActualizar.gridy = 3;
		panel.add(btnActualizar, gbc_btnActualizar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 128));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 11;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridwidth = 3;
		gbc_list.gridheight = 4;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 1;
		panel_1.add(list, gbc_list);

		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 7;
		gbc_btnNewButton_1.gridy = 1;
		panel_1.add(btnNewButton_1, gbc_btnNewButton_1);

		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridwidth = 3;
		gbc_list_1.gridheight = 4;
		gbc_list_1.insets = new Insets(0, 0, 5, 0);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 10;
		gbc_list_1.gridy = 1;
		panel_1.add(list_1, gbc_list_1);

		JButton btnNewButton_1_1 = new JButton("<");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1_1 = new GridBagConstraints();
		gbc_btnNewButton_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_1.gridx = 7;
		gbc_btnNewButton_1_1.gridy = 2;
		panel_1.add(btnNewButton_1_1, gbc_btnNewButton_1_1);

		JButton btnNewButton_1_2 = new JButton(">");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1_2 = new GridBagConstraints();
		gbc_btnNewButton_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_2.gridx = 7;
		gbc_btnNewButton_1_2.gridy = 3;
		panel_1.add(btnNewButton_1_2, gbc_btnNewButton_1_2);

		JButton btnNewButton_1_3 = new JButton(">>");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnNewButton_1_3 = new GridBagConstraints();
		gbc_btnNewButton_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1_3.gridx = 7;
		gbc_btnNewButton_1_3.gridy = 4;
		panel_1.add(btnNewButton_1_3, gbc_btnNewButton_1_3);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton btnGuardarLasNotas = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnGuardarLasNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnGuardarLasNotas = new GridBagConstraints();
		gbc_btnGuardarLasNotas.anchor = GridBagConstraints.EAST;
		gbc_btnGuardarLasNotas.gridwidth = 3;
		gbc_btnGuardarLasNotas.gridx = 7;
		gbc_btnGuardarLasNotas.gridy = 1;
		panel_2.add(btnGuardarLasNotas, gbc_btnGuardarLasNotas);
	}

	private void cargarListaDeAlumnos() {

	}

	private void cargarMateria() {
		List<Materia> lista = MateriaControlador.getInstancia().findAll();

		for (Materia m : lista) {
			this.comboBoxMateria.addItem(m);
		}
	}

	private void cargarProfesor() {
		List<Profesor> lista = ProfesorControlador.findAllProfesores();

		for (Profesor p : lista) {
			this.comboBoxProfesor.addItem(p);
		}
	}
	

	private void cargarNota() {

	}
}
