package com.temperatureAgile;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

public class ConvertTemp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConvertTemp frame = new ConvertTemp();
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
	public ConvertTemp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 499, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConvertTemperature = new JLabel("Convert Temperature");
		lblConvertTemperature.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConvertTemperature.setBounds(186, 5, 147, 37);
		panel.add(lblConvertTemperature);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(99, 84, 307, 191);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fahrenheit");
		lblNewLabel.setBounds(20, 22, 80, 23);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Celsius");
		lblNewLabel_1.setBounds(25, 80, 61, 14);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(103, 23, 96, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(103, 77, 96, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ConvertTemp.class.getResource("/com/images/sort.png")));
		btnNewButton.setBounds(30, 48, 28, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Calculate");
		btnNewButton_1.setBounds(103, 120, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel lblf = new JLabel("\u00B0F");
		lblf.setBounds(214, 26, 28, 14);
		panel_1.add(lblf);
		
		JLabel lblc = new JLabel("\u00B0C");
		lblc.setBounds(209, 80, 48, 14);
		panel_1.add(lblc);
	}
}
