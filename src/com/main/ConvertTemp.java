package com.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.exceptions.FieldEmptyException;
import com.exceptions.NonNumericException;
import com.exceptions.TemperatureException;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class ConvertTemp extends JFrame {

	private static ConvertTemp instance = new ConvertTemp();
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel labelError;
	public static ConvertTemp getInstance() {
		return instance;
	}

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
		
		JLabel lblOne = new JLabel("Fahrenheit");
		lblOne.setBounds(20, 22, 80, 23);
		panel_1.add(lblOne);
		
		JLabel lblTwo = new JLabel("Celsius");
		lblTwo.setBounds(20, 80, 61, 14);
		panel_1.add(lblTwo);
		
		textField1 = new JTextField();
		textField1.setBounds(103, 23, 96, 20);
		panel_1.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(103, 77, 96, 20);
		panel_1.add(textField2);
		textField2.setColumns(10);
		textField2.setEditable(false);
		
		
		
		JLabel lblUp = new JLabel("\u00B0F");
		lblUp.setBounds(209, 26, 28, 14);
		panel_1.add(lblUp);
		
		JLabel lblDown = new JLabel("\u00B0C");
		lblDown.setBounds(209, 80, 48, 14);
		panel_1.add(lblDown);
		JButton btnSwap = new JButton("");
		btnSwap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lblOne.getText().equals("Fahrenheit")) {
					lblOne.setText("Celsius");
					lblTwo.setText("Fahrenheit");
					lblUp.setText("°C");
					lblDown.setText("°F");
				} else {
					lblOne.setText("Fahrenheit");
					lblTwo.setText("Celsius");
					lblUp.setText("°F");
					lblDown.setText("°C");
				}
			}
		});
		
		labelError = new JLabel("");
		labelError.setForeground(Color.RED);
		labelError.setBounds(103, 166, 128, 14);
		panel_1.add(labelError);
		btnSwap.setIcon(new ImageIcon(ConvertTemp.class.getResource("/com/images/sort.png")));
		btnSwap.setBounds(30, 48, 28, 23);
		panel_1.add(btnSwap);
		
		JButton btnNewButton_1 = new JButton("Calculate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						calculateTemp(textField1.getText(),lblOne.getText());
					} catch (TemperatureException | FieldEmptyException | NonNumericException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnNewButton_1.setBounds(73, 120, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
			}
		});
		btnClear.setBounds(168, 120, 89, 23);
		panel_1.add(btnClear);
		
		NumberFormat format = DecimalFormat.getInstance();
	}
	public boolean validateField(String temperature) throws FieldEmptyException {	
		if(temperature.isEmpty()) {
			labelError.setText("Field is Empty");
			textField2.setText("");
			throw new FieldEmptyException("Field is Empty");
		}  return true;
	}
	public boolean validateInput(String input) throws NonNumericException {
		if(!input.matches("[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?")) { // ^[a-zA-Z]*$
			labelError.setText("Only numeric allowed");
			textField2.setText("");
			throw new NonNumericException("Only numeric allowed");
		}
				
		return true;
	}
	
	public void calculateTemp(String temperature, String type) throws TemperatureException,FieldEmptyException, NonNumericException{
		labelError.setText("");
		
		boolean text = validateField(temperature);
		boolean input = validateInput(temperature);
		if(text && input) {
			if(type.equals("Fahrenheit")) {	
				textField2.setText(calculateC(temperature));
			} else if(type.equals("Celsius")) {
				textField2.setText(calculateF(temperature));
			}
		}
	}
	public String calculateF(String temperature) throws TemperatureException {
		double fahrenheit,celsius;
		celsius = Double.parseDouble(temperature);
		if(celsius < -273.15 || celsius > 100) {
			labelError.setText("Value not in range");
			textField2.setText("");
			throw new TemperatureException("Value not in range");
		}
		fahrenheit = (celsius*9/5) + 32;
		return String.valueOf(new DecimalFormat("0.00").format(fahrenheit));
		
		
	}
	public String calculateC(String temperature) throws TemperatureException {
		double fahrenheit,celsius;
		fahrenheit = Double.parseDouble(temperature);
		if(fahrenheit < -459.67 || fahrenheit > 212) {
			labelError.setText("Value not in range");
			textField2.setText("");
			throw new TemperatureException("Value not in range");
		}
			
		celsius = (fahrenheit - 32) * 5/9;
		return String.valueOf(new DecimalFormat("0.00").format(celsius));
	}
}
