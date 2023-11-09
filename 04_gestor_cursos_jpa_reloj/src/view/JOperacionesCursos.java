package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FormacionService;
import service.FormacionServiceFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class JOperacionesCursos extends JFrame implements Runnable {
											   // Para poder crear el Thread del reloj.

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblReloj = new JLabel("");
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOperacionesCursos frame = new JOperacionesCursos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JOperacionesCursos() {
		setTitle("Gestor de cursos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAcciones = new JMenu("Acciones");
		menuBar.add(mnAcciones);
		
		JMenuItem itActualizar = new JMenuItem("Actualizar datos");
		itActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// var fs = new FormacionService();
				var service = FormacionServiceFactory.getFormacionService();
				service.actualizarDatos();
			}
		});
		mnAcciones.add(itActualizar);
		
		JMenuItem itConsulta = new JMenuItem("Consulta");
		itConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JConsulta();
			}
		});
		mnAcciones.add(itConsulta);
		
		JMenuItem itBorrar = new JMenuItem("\"Eliminar\" alumnos");
		itBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JBorrar();
			}
		});
		mnAcciones.add(itBorrar);
		
		JMenuItem itCursosFechas = new JMenuItem("Cursos por fechas");
		itCursosFechas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JBuscadorCursos();
			}
		});
		mnAcciones.add(itCursosFechas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReloj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReloj.setHorizontalAlignment(SwingConstants.CENTER);
		lblReloj.setBounds(242, 87, 133, 34);
		contentPane.add(lblReloj);
		
		new Thread(this).start();
		/* Arranca el reloj. This porque la propia clase es runnable */
	}

	@Override					// Obligatorio al implementar la interfaz Runnable
	public void run() {
		while (true) {
			var time = LocalTime.now();
			lblReloj.setText(time.toString());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}