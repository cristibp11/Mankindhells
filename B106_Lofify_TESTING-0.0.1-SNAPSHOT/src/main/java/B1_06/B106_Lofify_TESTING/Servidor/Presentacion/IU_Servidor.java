package B1_06.B106_Lofify_TESTING.Servidor.Presentacion;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JButton;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class IU_Servidor {

	private JFrame frame;
	private JTabbedPane tpnlMOD1;
	private JPanel pnlCanciones;
	private JPanel pnlAlbumes;
	private JButton btnAadir;
	private JPanel pnlMOD1;
	private JPanel pnlBotones;
	private JPanel pnlForm;
	private JButton btnCancelar;
	private JPanel pnlListado;
	private JPanel pnlForm2;
	private JPanel pnlListado2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Servidor window = new IU_Servidor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IU_Servidor() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 709, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		pnlMOD1 = new JPanel();
		frame.getContentPane().add(pnlMOD1, "name_172617068452863");
		pnlMOD1.setLayout(new BorderLayout(0, 0));
		
		pnlBotones = new JPanel();
		pnlMOD1.add(pnlBotones, BorderLayout.SOUTH);
		pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new BtnAadirActionListener());
		pnlBotones.add(btnAadir);
		
		tpnlMOD1 = new JTabbedPane(JTabbedPane.TOP);
		pnlMOD1.add(tpnlMOD1, BorderLayout.CENTER);
		
		pnlCanciones = new JPanel();
		tpnlMOD1.addTab("Canciones", null, pnlCanciones, null);
		pnlCanciones.setLayout(new BorderLayout(0, 0));
		
		pnlForm = new JPanel();
		pnlCanciones.add(pnlForm, BorderLayout.SOUTH);
		pnlForm.setLayout(new GridLayout(1, 1, 0, 0));
		
		pnlListado = new JPanel();
		pnlCanciones.add(pnlListado, BorderLayout.CENTER);
		pnlListado.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 5));
		
		pnlAlbumes = new JPanel();
		tpnlMOD1.addTab("Álbumes", null, pnlAlbumes, null);
		pnlAlbumes.setLayout(new BorderLayout(0, 0));
		
		pnlForm2 = new JPanel();
		pnlAlbumes.add(pnlForm2, BorderLayout.SOUTH);
		
		pnlListado2 = new JPanel();
		pnlAlbumes.add(pnlListado2, BorderLayout.CENTER);
	}
	
	private class item_Cancion extends JPanel {
		private static final long serialVersionUID = 1L;
		private JTextField textField;
		public item_Cancion(String nombre) {
			setBorder(new LineBorder(Color.BLUE, 2));
			setLayout(new GridLayout(1, 1, 0, 0));
			
			textField = new JTextField(nombre);
			add(textField);
			textField.setColumns(10);

		}
	}
	
	private class Form_Canciones extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel lblTitulo;
		private JTextField txtTitulo;
		private JLabel lblMetadatos;
		private JTextField txtMetadatos;
		private JLabel lblPrecio;
		private JFormattedTextField ftxtPrecio;
		private JLabel lblAutor;
		private JTextField txtAutor;
		private JLabel lbllbum;
		private JTextField txtAlbum;
		private JButton btnAceptar;

		/**
		 * Create the panel.
		 */
		public Form_Canciones() {
			GridBagLayout gridBagLayout = new GridBagLayout();
			gridBagLayout.columnWidths = new int[]{84, 225, 0, 0};
			gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 0};
			gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			setLayout(gridBagLayout);
			
			lblTitulo = new JLabel("Titulo:");
			GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
			gbc_lblTitulo.anchor = GridBagConstraints.EAST;
			gbc_lblTitulo.fill = GridBagConstraints.VERTICAL;
			gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitulo.gridx = 0;
			gbc_lblTitulo.gridy = 0;
			add(lblTitulo, gbc_lblTitulo);
			
			txtTitulo = new JTextField();
			GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
			gbc_txtTitulo.gridwidth = 2;
			gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTitulo.insets = new Insets(0, 0, 5, 5);
			gbc_txtTitulo.gridx = 1;
			gbc_txtTitulo.gridy = 0;
			add(txtTitulo, gbc_txtTitulo);
			txtTitulo.setColumns(10);
			
			lblMetadatos = new JLabel("Metadatos:");
			GridBagConstraints gbc_lblMetadatos = new GridBagConstraints();
			gbc_lblMetadatos.anchor = GridBagConstraints.EAST;
			gbc_lblMetadatos.fill = GridBagConstraints.VERTICAL;
			gbc_lblMetadatos.insets = new Insets(0, 0, 5, 5);
			gbc_lblMetadatos.gridx = 0;
			gbc_lblMetadatos.gridy = 1;
			add(lblMetadatos, gbc_lblMetadatos);
			
			txtMetadatos = new JTextField();
			GridBagConstraints gbc_txtMetadatos = new GridBagConstraints();
			gbc_txtMetadatos.gridwidth = 2;
			gbc_txtMetadatos.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtMetadatos.insets = new Insets(0, 0, 5, 5);
			gbc_txtMetadatos.gridx = 1;
			gbc_txtMetadatos.gridy = 1;
			add(txtMetadatos, gbc_txtMetadatos);
			txtMetadatos.setColumns(10);
			
			lblPrecio = new JLabel("Precio:");
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.anchor = GridBagConstraints.EAST;
			gbc_lblPrecio.fill = GridBagConstraints.VERTICAL;
			gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrecio.gridx = 0;
			gbc_lblPrecio.gridy = 2;
			add(lblPrecio, gbc_lblPrecio);
			
			try{
				ftxtPrecio = new JFormattedTextField(new MaskFormatter("##'.##"));
			}catch (ParseException e){
				e.printStackTrace();
			}
			GridBagConstraints gbc_ftxtPrecio = new GridBagConstraints();
			gbc_ftxtPrecio.gridwidth = 2;
			gbc_ftxtPrecio.fill = GridBagConstraints.HORIZONTAL;
			gbc_ftxtPrecio.insets = new Insets(0, 0, 5, 5);
			gbc_ftxtPrecio.gridx = 1;
			gbc_ftxtPrecio.gridy = 2;
			add(ftxtPrecio, gbc_ftxtPrecio);
			
			lblAutor = new JLabel("Autor:");
			GridBagConstraints gbc_lblAutor = new GridBagConstraints();
			gbc_lblAutor.anchor = GridBagConstraints.EAST;
			gbc_lblAutor.fill = GridBagConstraints.VERTICAL;
			gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
			gbc_lblAutor.gridx = 0;
			gbc_lblAutor.gridy = 3;
			add(lblAutor, gbc_lblAutor);
			
			txtAutor = new JTextField();
			GridBagConstraints gbc_txtAutor = new GridBagConstraints();
			gbc_txtAutor.gridwidth = 2;
			gbc_txtAutor.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAutor.insets = new Insets(0, 0, 5, 5);
			gbc_txtAutor.gridx = 1;
			gbc_txtAutor.gridy = 3;
			add(txtAutor, gbc_txtAutor);
			txtAutor.setColumns(10);
			
			lbllbum = new JLabel("Álbum:");
			GridBagConstraints gbc_lbllbum = new GridBagConstraints();
			gbc_lbllbum.anchor = GridBagConstraints.EAST;
			gbc_lbllbum.fill = GridBagConstraints.VERTICAL;
			gbc_lbllbum.insets = new Insets(0, 0, 5, 5);
			gbc_lbllbum.gridx = 0;
			gbc_lbllbum.gridy = 4;
			add(lbllbum, gbc_lbllbum);
			
			txtAlbum = new JTextField();
			GridBagConstraints gbc_txtAlbum = new GridBagConstraints();
			gbc_txtAlbum.gridwidth = 2;
			gbc_txtAlbum.insets = new Insets(0, 0, 5, 5);
			gbc_txtAlbum.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAlbum.gridx = 1;
			gbc_txtAlbum.gridy = 4;
			add(txtAlbum, gbc_txtAlbum);
			txtAlbum.setColumns(10);
			
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new BtnFormActionListener());
			GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
			gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
			gbc_btnAceptar.anchor = GridBagConstraints.EAST;
			gbc_btnAceptar.gridx = 1;
			gbc_btnAceptar.gridy = 5;
			add(btnAceptar, gbc_btnAceptar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new BtnFormActionListener());
			GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
			gbc_btnCancelar.gridx = 2;
			gbc_btnCancelar.gridy = 5;
			add(btnCancelar, gbc_btnCancelar);

		}
		
		private class BtnFormActionListener implements ActionListener {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals("Aceptar")){
					pnlListado.add(new item_Cancion(txtTitulo.getText()));
					pnlListado.revalidate();
					pnlListado.repaint();
				}
				pnlForm.remove(pnlForm.getComponent(0));
				pnlForm.revalidate();
				pnlForm.repaint();
				btnAadir.setEnabled(true);
			}
		}

	}
	
	private class BtnAadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnAadir.setEnabled(false);
			switch(tpnlMOD1.getSelectedIndex()){
			case 0:
				pnlForm.add(new Form_Canciones());
				pnlForm.revalidate();
				pnlForm.repaint();
			case 1:
				
			}
		}
	}

}
