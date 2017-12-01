package Servidor.Presentacion;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.UIManager;

public class InfoArtista extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblImage;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblCalendarIcon;
	private JList<String> list;
	private JList<String> list_1;

	/**
	 * Create the panel.
	 */
	public InfoArtista(String nombre) {
		setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 180, 30, 41, 50, 0, 0};
		gridBagLayout.rowHeights = new int[] {60, 60, 60, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		list.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Canciones del Artista", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.gridheight = 3;
		gbc_list.gridwidth = 2;
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 0;
		add(list, gbc_list);
		
		list_1 = new JList<String>();
		list_1.setBorder(new TitledBorder(null, "\u00C1lbumes del Artista", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridheight = 3;
		gbc_list_1.gridwidth = 4;
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 1;
		gbc_list_1.gridy = 4;
		add(list_1, gbc_list_1);
		
		lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 8;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 3;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 8;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblCalendarIcon = new JLabel("");
		GridBagConstraints gbc_lblCalendarIcon = new GridBagConstraints();
		gbc_lblCalendarIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalendarIcon.gridx = 4;
		gbc_lblCalendarIcon.gridy = 8;
		add(lblCalendarIcon, gbc_lblCalendarIcon);

	}
	
	public String getNombre(){
		return txtNombre.getText();
	}
	
	public String getDescripcion(){
		return "";
	}

}
