package Servidor.Presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.border.TitledBorder;

import Servidor.Dominio.Album;
import Servidor.Dominio.Artista;
import Servidor.Dominio.Cancion;

import javax.swing.UIManager;
import java.awt.Color;

public class IU_Servidor {

	private JFrame frmAdmin;
	private JPanel pnlPrincipal;
	private JPanel pnlMenu;
	private JPanel pnlControles;
	private JToolBar toolBar;
	private JButton btnAadirElemento;
	private JButton btnEnviarMensaje;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JSplitPane splitPane;
	private JPanel pnlDatos;
	private JPanel pnlInfo;
	private JComboBox<String> comboBox;
	private JList<String> list;
	private JPanel pnlBusqueda;
	private JTextField textField;
	private JButton btnBuscar;
	private JPanel pnlInfoDeElemento;
	private JPanel pnlAñadir;
	private JToolBar toolBar_1;
	private JButton btnAtrs;
	private JPanel pnlControles2;
	private JButton btnCrear;
	private JPanel pnlInfo2;
	private JPanel pnlType;
	private JLabel lblEscojaQueTipo;
	private JComboBox<String> comboBox_1;
	private JPanel pnlInfoDeElemento2;
	private JPanel pnlMensajes;
	private JToolBar toolBar_2;
	private JButton btnAtrs_1;
	private JPanel pnlControles3;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private TextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Servidor window = new IU_Servidor();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IU_Servidor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("Admin");
		frmAdmin.setBounds(100, 100, 878, 630);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(new CardLayout(0, 0));
		
		pnlPrincipal = new JPanel();
		frmAdmin.getContentPane().add(pnlPrincipal, "Principal");
		pnlPrincipal.setLayout(new BorderLayout(0, 0));
		
		pnlMenu = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlMenu.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlPrincipal.add(pnlMenu, BorderLayout.NORTH);
		
		toolBar = new JToolBar();
		toolBar.setBorder(null);
		pnlMenu.add(toolBar);
		
		btnAadirElemento = new JButton("Añadir elemento");
		btnAadirElemento.addActionListener(new BtnToolBarActionListener());
		toolBar.add(btnAadirElemento);

		pnlAñadir = new JPanel();
		frmAdmin.getContentPane().add(pnlAñadir, "Añadir elemento");
		pnlAñadir.setLayout(new BorderLayout(0, 0));
		
		toolBar_1 = new JToolBar();
		toolBar_1.setBorder(null);
		pnlAñadir.add(toolBar_1, BorderLayout.NORTH);
		
		btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new BtnAtrsActionListener());
		toolBar_1.add(btnAtrs);
		
		pnlControles2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlControles2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnlAñadir.add(pnlControles2, BorderLayout.SOUTH);
		
		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new BtnCrearActionListener());
		pnlControles2.add(btnCrear);
		
		pnlInfo2 = new JPanel();
		pnlAñadir.add(pnlInfo2, BorderLayout.CENTER);
		pnlInfo2.setLayout(new BorderLayout(0, 0));
		
		pnlType = new JPanel();
		pnlInfo2.add(pnlType, BorderLayout.NORTH);
		
		lblEscojaQueTipo = new JLabel("Escoja que tipo de elemento desea introducir:");
		pnlType.add(lblEscojaQueTipo);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addActionListener(new ComboBox_1ActionListener());
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Canci\u00F3n", "\u00C1lbum", "Artista"}));
		pnlType.add(comboBox_1);
		
		pnlInfoDeElemento2 = new JPanel();
		pnlInfo2.add(pnlInfoDeElemento2, BorderLayout.CENTER);
		pnlInfoDeElemento2.setLayout(new GridLayout(0, 1, 0, 0));
		pnlInfoDeElemento2.add(new InfoCancion(""));
		
	}

	private class BtnToolBarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)frmAdmin.getContentPane().getLayout()).show(frmAdmin.getContentPane(), e.getActionCommand());
		}
	}
	private class ComboBox_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			pnlInfoDeElemento2.removeAll();
			switch(comboBox_1.getSelectedIndex()){
			case 0:
				pnlInfoDeElemento2.add(new InfoCancion(""));
				break;
			case 1:
				pnlInfoDeElemento2.add(new InfoAlbum(""));
				break;
			case 2:
				pnlInfoDeElemento2.add(new InfoArtista(""));
				break;
			}
			pnlInfoDeElemento2.revalidate();
			pnlInfoDeElemento2.repaint();
		}
	}
	private class BtnAtrsActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			((CardLayout)frmAdmin.getContentPane().getLayout()).show(frmAdmin.getContentPane(), "Principal");
		}
	}
	private class BtnCrearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			switch(comboBox_1.getSelectedIndex()){
			case 0:
				InfoCancion component1 = (InfoCancion) pnlInfoDeElemento2.getComponent(0);
				
				try{
					Cancion.addCancion(component1.getNombre(), component1.getMetadatos(), component1.getPrecio(), component1.getArtista(),component1.getAlbum());
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 1:
				InfoAlbum component2 = (InfoAlbum) pnlInfoDeElemento2.getComponent(0);
				
				try{
					Album.addAlbum(component2.getNombre(), component2.getPrecio(), component2.getArtista());
					
				}catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				InfoArtista component = (InfoArtista) pnlInfoDeElemento2.getComponent(0);
				try {
					Artista.addArtista(component.getNombre(), component.getDescripcion());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
			((CardLayout)frmAdmin.getContentPane().getLayout()).show(frmAdmin.getContentPane(), "Principal");
		}
	}
	
}
