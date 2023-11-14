package view;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import view.adapters.ComboTiendasModel;
import view.adapters.TablaPedidosModel;

public class JPedidosTiendas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbPedidos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPedidosTiendas frame = new JPedidosTiendas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JPedidosTiendas() {
		setTitle("Pedidos por tiendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbTiendas = new JComboBox();
		cbTiendas.setBounds(138, 11, 165, 22);
		cbTiendas.setModel(new ComboTiendasModel());
		cbTiendas.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				tbPedidos.setModel(new TablaPedidosModel(cbTiendas.getSelectedItem().toString()));
			}
		});
		contentPane.add(cbTiendas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(398, 248, -349, -175);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 70, 374, 167);
		contentPane.add(scrollPane_1);
		
		tbPedidos = new JTable();
		scrollPane_1.setViewportView(tbPedidos);
	}
}