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
import java.util.LinkedList;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import javax.swing.border.TitledBorder;

import Servidor.Dominio.Album;
import Servidor.Dominio.Artista;
import Servidor.Dominio.Cancion;
import Servidor.Dominio.Gestor_Dominio;

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
		
		btnAadirElemento = new JButton("A\u00F1adir elemento");
		btnAadirElemento.addActionListener(new BtnToolBarActionListener());
		toolBar.add(btnAadirElemento);
		
		btnEnviarMensaje = new JButton("Enviar mensaje");
		btnEnviarMensaje.addActionListener(new BtnToolBarActionListener());
		toolBar.add(btnEnviarMensaje);
		
		pnlControles = new JPanel();
		pnlPrincipal.add(pnlControles, BorderLayout.SOUTH);
		
	
		splitPane = new JSplitPane();
		pnlPrincipal.add(splitPane, BorderLayout.CENTER);
		
		pnlDatos = new JPanel();
		pnlDatos.setMinimumSize(new Dimension(230, 10));
		splitPane.setLeftComponent(pnlDatos);
		GridBagLayout gbl_pnlDatos = new GridBagLayout();
		gbl_pnlDatos.columnWidths = new int[]{0, 0};
		gbl_pnlDatos.rowHeights = new int[]{0, 0, 0};
		gbl_pnlDatos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlDatos.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pnlDatos.setLayout(gbl_pnlDatos);
		
		comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ComboBoxActionListener());
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Nombre Canci\u00F3n", "Nombre \u00C1lbum", "Nombre Artista"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 0;
		pnlDatos.add(comboBox, gbc_comboBox);
		
		list = new JList<String>();
		list.addMouseListener(new ListMouseListener());
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		pnlDatos.add(list, gbc_list);
		
		pnlInfo = new JPanel();
		splitPane.setRightComponent(pnlInfo);
		pnlInfo.setLayout(new BorderLayout(0, 0));
		
		pnlBusqueda = new JPanel();
		pnlInfo.add(pnlBusqueda, BorderLayout.NORTH);
		GridBagLayout gbl_pnlBusqueda = new GridBagLayout();
		gbl_pnlBusqueda.columnWidths = new int[]{0, 0, 0};
		gbl_pnlBusqueda.rowHeights = new int[]{0, 0};
		gbl_pnlBusqueda.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_pnlBusqueda.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlBusqueda.setLayout(gbl_pnlBusqueda);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		pnlBusqueda.add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new btnBuscarActionListener());
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 0;
		pnlBusqueda.add(btnBuscar, gbc_btnBuscar);
		
		pnlInfoDeElemento = new JPanel();
		pnlInfo.add(pnlInfoDeElemento, BorderLayout.CENTER);
		pnlInfoDeElemento.setLayout(new GridLayout(0, 1, 0, 0));
		
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

	private class ListMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			pnlInfoDeElemento.removeAll();
			switch(comboBox.getSelectedIndex()){
			case 0:
				pnlInfoDeElemento.add(new InfoCancion(list.getSelectedValue()));
				break;
			case 1:
				pnlInfoDeElemento.add(new InfoAlbum(list.getSelectedValue()));
				break;
			case 2:
				pnlInfoDeElemento.add(new InfoArtista(list.getSelectedValue()));
				break;
			}
			pnlInfoDeElemento.revalidate();
			pnlInfoDeElemento.repaint();
		}
	}
	private class ComboBoxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			list.clearSelection();
		}
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
					Cancion.addCancion(component1.getNombre(),component1.getMetadatos(), component1.getPrecio(), component1.getArtista(),component1.getAlbum());

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
	private class btnBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			switch(comboBox.getSelectedIndex()){
			case 0:
				try {
					
					Gestor_Dominio.buscarCancion(textField.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 1:
				try {
					
					Gestor_Dominio.buscarAlbum(textField.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 2:
				try {
					LinkedList<Artista> lista = Gestor_Dominio.buscarArtista(textField.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			}
			
		}
	}
}
