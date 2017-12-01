package Servidor.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Servidor.Dominio.Album;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class InfoCancion extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblImage;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblArtista;
	private JTextField txtArtista;
	private JLabel lbllbum;
	private JTextField txtAlbum;
	private JLabel lblPrecio;
	private JFormattedTextField ftxtPrecio;
	private JLabel lblLanzamiento;
	private JFormattedTextField ftxtLanzamiento;
	private JLabel lblCalendarIcon;

	/**
	 * Create the panel.
	 */
	public InfoCancion(String titulo) {
		setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 150, 0, 41, 50, 0};
		gridBagLayout.rowHeights = new int[] {50, 50, 50, 50, 50, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.gridheight = 3;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 0;
		add(lblImage, gbc_lblImage);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 0;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 3;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblArtista = new JLabel("Artista:");
		GridBagConstraints gbc_lblArtista = new GridBagConstraints();
		gbc_lblArtista.anchor = GridBagConstraints.EAST;
		gbc_lblArtista.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtista.gridx = 2;
		gbc_lblArtista.gridy = 1;
		add(lblArtista, gbc_lblArtista);
		
		txtArtista = new JTextField();
		GridBagConstraints gbc_txtArtista = new GridBagConstraints();
		gbc_txtArtista.gridwidth = 2;
		gbc_txtArtista.insets = new Insets(0, 0, 5, 0);
		gbc_txtArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArtista.gridx = 3;
		gbc_txtArtista.gridy = 1;
		add(txtArtista, gbc_txtArtista);
		txtArtista.setColumns(10);
		
		lbllbum = new JLabel("\u00C1lbum:");
		GridBagConstraints gbc_lbllbum = new GridBagConstraints();
		gbc_lbllbum.anchor = GridBagConstraints.EAST;
		gbc_lbllbum.insets = new Insets(0, 0, 5, 5);
		gbc_lbllbum.gridx = 2;
		gbc_lbllbum.gridy = 2;
		add(lbllbum, gbc_lbllbum);
		
		txtAlbum = new JTextField();
		GridBagConstraints gbc_txtAlbum = new GridBagConstraints();
		gbc_txtAlbum.gridwidth = 2;
		gbc_txtAlbum.insets = new Insets(0, 0, 5, 0);
		gbc_txtAlbum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlbum.gridx = 3;
		gbc_txtAlbum.gridy = 2;
		add(txtAlbum, gbc_txtAlbum);
		txtAlbum.setColumns(10);
		
		lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 2;
		gbc_lblPrecio.gridy = 3;
		add(lblPrecio, gbc_lblPrecio);
		
		ftxtPrecio = new JFormattedTextField();
		GridBagConstraints gbc_ftxtPrecio = new GridBagConstraints();
		gbc_ftxtPrecio.gridwidth = 2;
		gbc_ftxtPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_ftxtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtPrecio.gridx = 3;
		gbc_ftxtPrecio.gridy = 3;
		add(ftxtPrecio, gbc_ftxtPrecio);
		
		lblLanzamiento = new JLabel("Lanzamiento:");
		GridBagConstraints gbc_lblLanzamiento = new GridBagConstraints();
		gbc_lblLanzamiento.anchor = GridBagConstraints.EAST;
		gbc_lblLanzamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblLanzamiento.gridx = 2;
		gbc_lblLanzamiento.gridy = 4;
		add(lblLanzamiento, gbc_lblLanzamiento);
		
		ftxtLanzamiento = new JFormattedTextField();
		GridBagConstraints gbc_ftxtLanzamiento = new GridBagConstraints();
		gbc_ftxtLanzamiento.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtLanzamiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtLanzamiento.gridx = 3;
		gbc_ftxtLanzamiento.gridy = 4;
		add(ftxtLanzamiento, gbc_ftxtLanzamiento);
		
		lblCalendarIcon = new JLabel("");
		GridBagConstraints gbc_lblCalendarIcon = new GridBagConstraints();
		gbc_lblCalendarIcon.insets = new Insets(0, 0, 5, 0);
		gbc_lblCalendarIcon.gridx = 4;
		gbc_lblCalendarIcon.gridy = 4;
		add(lblCalendarIcon, gbc_lblCalendarIcon);

	}
	public String getNombre(){
		return txtNombre.getText();
	}
	
	public String getArtista(){
		return txtArtista.getText();
	}
	
	public String getAlbum(){
		return txtAlbum.getText();
	}
	
	public double getPrecio(){
		return Double.parseDouble(ftxtPrecio.getText());
	}
	
	public String getMetadatos(){
		return "metadatos."+ txtArtista.getText();
	}
}
