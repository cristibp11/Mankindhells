package Servidor.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;

public class InfoAlbum extends JPanel {
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
	private JList<String> list;

	/**
	 * Create the panel.
	 */
	public InfoAlbum(String nombre) {
		setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{27, 180, 30, 41, 50, 0, 0};
		gridBagLayout.rowHeights = new int[] {60, 60, 60, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblImage = new JLabel("");
		lblImage.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.gridheight = 3;
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 0;
		add(lblImage, gbc_lblImage);
		
		list = new JList<String>();
		list.setBorder(new TitledBorder(null, "Canciones del \u00C1lbum", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 0;
		add(list, gbc_list);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 4;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 4;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblArtista = new JLabel("Artista:");
		GridBagConstraints gbc_lblArtista = new GridBagConstraints();
		gbc_lblArtista.anchor = GridBagConstraints.EAST;
		gbc_lblArtista.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtista.gridx = 1;
		gbc_lblArtista.gridy = 5;
		add(lblArtista, gbc_lblArtista);
		
		txtArtista = new JTextField();
		GridBagConstraints gbc_txtArtista = new GridBagConstraints();
		gbc_txtArtista.gridwidth = 3;
		gbc_txtArtista.insets = new Insets(0, 0, 5, 5);
		gbc_txtArtista.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtArtista.gridx = 2;
		gbc_txtArtista.gridy = 5;
		add(txtArtista, gbc_txtArtista);
		txtArtista.setColumns(10);
		
		lblCalendarIcon = new JLabel("");
		GridBagConstraints gbc_lblCalendarIcon = new GridBagConstraints();
		gbc_lblCalendarIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalendarIcon.gridx = 4;
		gbc_lblCalendarIcon.gridy = 8;
		add(lblCalendarIcon, gbc_lblCalendarIcon);
		
		lbllbum = new JLabel("\u00C1lbum:");
		GridBagConstraints gbc_lbllbum = new GridBagConstraints();
		gbc_lbllbum.anchor = GridBagConstraints.EAST;
		gbc_lbllbum.insets = new Insets(0, 0, 5, 5);
		gbc_lbllbum.gridx = 1;
		gbc_lbllbum.gridy = 6;
		add(lbllbum, gbc_lbllbum);
		
		txtAlbum = new JTextField();
		GridBagConstraints gbc_txtAlbum = new GridBagConstraints();
		gbc_txtAlbum.gridwidth = 3;
		gbc_txtAlbum.insets = new Insets(0, 0, 5, 5);
		gbc_txtAlbum.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAlbum.gridx = 2;
		gbc_txtAlbum.gridy = 6;
		add(txtAlbum, gbc_txtAlbum);
		txtAlbum.setColumns(10);
		
		lblPrecio = new JLabel("Precio:");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 1;
		gbc_lblPrecio.gridy = 7;
		add(lblPrecio, gbc_lblPrecio);
		
		ftxtPrecio = new JFormattedTextField();
		GridBagConstraints gbc_ftxtPrecio = new GridBagConstraints();
		gbc_ftxtPrecio.gridwidth = 3;
		gbc_ftxtPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtPrecio.gridx = 2;
		gbc_ftxtPrecio.gridy = 7;
		add(ftxtPrecio, gbc_ftxtPrecio);
		
		lblLanzamiento = new JLabel("Lanzamiento:");
		GridBagConstraints gbc_lblLanzamiento = new GridBagConstraints();
		gbc_lblLanzamiento.anchor = GridBagConstraints.EAST;
		gbc_lblLanzamiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblLanzamiento.gridx = 1;
		gbc_lblLanzamiento.gridy = 8;
		add(lblLanzamiento, gbc_lblLanzamiento);
		
		ftxtLanzamiento = new JFormattedTextField();
		GridBagConstraints gbc_ftxtLanzamiento = new GridBagConstraints();
		gbc_ftxtLanzamiento.gridwidth = 2;
		gbc_ftxtLanzamiento.insets = new Insets(0, 0, 5, 5);
		gbc_ftxtLanzamiento.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftxtLanzamiento.gridx = 2;
		gbc_ftxtLanzamiento.gridy = 8;
		add(ftxtLanzamiento, gbc_ftxtLanzamiento);

	}
	
	public String getNombre(){
		return txtNombre.getText();
	}
	
	public double getPrecio(){
		return Double.parseDouble(ftxtPrecio.getText());
	}
	
	public String getArtista(){
		return txtArtista.getText();
	}

}
