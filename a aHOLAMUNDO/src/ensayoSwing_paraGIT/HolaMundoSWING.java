package ensayoSwing_paraGIT;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class HolaMundoSWING extends JFrame implements ActionListener {

	private JPanel panelPrincipal;
	private JButton btnIncrementar1;
	private JButton btnIncrementar10;
	private int contador;
	private JLabel lblIncrementar;
	private JCheckBox chckbxBotones;
	private JComboBox<String> cmbBox;

	public static void main(String[] args) {
		HolaMundoSWING ventana = new HolaMundoSWING();
		ventana.setVisible(true);
	}

	public HolaMundoSWING() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		panelPrincipal.setBackground(Color.GREEN);
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BorderLayout());

		btnIncrementar1 = new JButton("Hola");
		panelPrincipal.add(btnIncrementar1, BorderLayout.SOUTH);
		btnIncrementar1.addActionListener(this);

		btnIncrementar10 = new JButton("Mundo");
		panelPrincipal.add(btnIncrementar10, BorderLayout.NORTH);
		btnIncrementar10.addActionListener(this);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		int height = toolkit.getScreenSize().height - 500;
		int width = toolkit.getScreenSize().width - 500;
		setPreferredSize(new Dimension(width, height));
		pack();
		setLocationRelativeTo(null);

		setContentPane(panelPrincipal);

		lblIncrementar = new JLabel("New label");
		lblIncrementar.setHorizontalAlignment(SwingConstants.CENTER);
		panelPrincipal.add(lblIncrementar, BorderLayout.CENTER);

		setVisible(true);
		contador = 0;
		lblIncrementar.setText("Todavía no se ha pulsado el botón");

		chckbxBotones = new JCheckBox("Activar botones");
		chckbxBotones.setSelected(true);
		panelPrincipal.add(chckbxBotones, BorderLayout.WEST);
		chckbxBotones.addActionListener(this);

		cmbBox = new JComboBox<>();
		panelPrincipal.add(cmbBox, BorderLayout.EAST);

		String[] opciones = new String[] { "Hola", "Mundo", "Swing" };
		for (String opcion : opciones) {
			cmbBox.addItem(opcion);
		}
		cmbBox.setSelectedIndex(1);
		cmbBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println("Nueva opción seleccionada: " +
						cmbBox.getSelectedItem());
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Hola":
			gestionarPulsacionBotonIncrementar1();
			break;
		case "Mundo":
			gestionarPulsacionBotonIncrementar10();
			break;
		case "Activar botones":
			gestionarActivacionBotones();
		
		}
	}

	public void gestionarPulsacionBotonIncrementar10() {
		contador += 10;
		lblIncrementar.setText("Contador: " + contador);
	}

	public void gestionarPulsacionBotonIncrementar1() {
		contador++;
		// escribo en el label el valor de contador
		lblIncrementar.setText("Contador: " + contador);

		System.out.println(contador);
		if (contador % 2 == 0) {
			panelPrincipal.setBackground(Color.GREEN);
			btnIncrementar1.setForeground(Color.red);
		} else {
			panelPrincipal.setBackground(Color.yellow);
			btnIncrementar1.setForeground(Color.blue);
		}
	}

	public void gestionarActivacionBotones() {
		// si el checkbox esta activado -> activamos los botones
		if (chckbxBotones.isSelected()) {
			System.out.println("activo botones");
			btnIncrementar1.setEnabled(true);
			btnIncrementar10.setEnabled(true);
		} else {
			System.out.println("desactivo botones");
			btnIncrementar1.setEnabled(false);
			btnIncrementar10.setEnabled(false);
		}
	}
}