package com.company;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class FormulasGraphics extends JPanel implements ActionListener {

    private JTextField aInput;
    private JTextField bInput;

    private JTextField aInput2;
    private JTextField bInput2;
    private JTextField cInput2;

    private JTextField radiusInput;

    private JTextField radiusInput2;
    private JTextField heightInput;

    private Color black;
    private Color blackboard;
    private Color white;

    private double c;
    private double sol1;
    private double sol2;
    private double volSphere;
    private double volCyl;

    private JButton volSphereButton;
    private JButton volCylButton;
    private JButton solveQuadButton;
    private JButton solvePythagButton;

    private boolean check;



    public FormulasGraphics() {
        setLayout(null); //Not using a layout

        c = 0;
        sol1 = 0;
        sol2 = 0;
        volSphere = 0;
        volCyl = 0;
        check = true;

        black = new Color(0, 0, 0);
        blackboard = new Color(14, 125, 55);
        white = new Color(255, 255, 255);

        radiusInput = new JTextField();
        radiusInput.setBounds(100, 200, 200, 30); //Takes in x and y location and the width and the height
        add(radiusInput);

        radiusInput2 = new JTextField();
        radiusInput2.setBounds(100, 500, 200, 30);
        add(radiusInput2);

        heightInput = new JTextField();
        heightInput.setBounds(100, 550, 200, 30);
        add(heightInput);

        aInput = new JTextField();
        aInput.setBounds(500, 500, 200, 30);
        add(aInput);

        bInput = new JTextField();
        bInput.setBounds(500, 550, 200, 30);
        add(bInput);

        aInput2 = new JTextField();
        aInput2.setBounds(500, 200, 30, 30);
        add(aInput2);

        bInput2 = new JTextField();
        bInput2.setBounds(575, 200, 30, 30);
        add(bInput2);

        cInput2 = new JTextField();
        cInput2.setBounds(640, 200, 30, 30);
        add(cInput2);

        volCylButton = new JButton("Volume of a Cylinder");
        volCylButton.setBounds(100, 650, 200, 30);
        add(volCylButton);
        volCylButton.addActionListener(this);

        volSphereButton = new JButton("Volume of a Sphere");
        volSphereButton.setBounds(100, 300, 200, 30);
        add(volSphereButton);
        volSphereButton.addActionListener(this);

        solveQuadButton = new JButton("Solve Quadratic");
        solveQuadButton.setBounds(500, 300, 200, 30);
        add(solveQuadButton);
        solveQuadButton.addActionListener(this);

        solvePythagButton = new JButton("Pythagorean Theorem");
        solvePythagButton.setBounds(500, 650, 200, 30);
        add(solvePythagButton);
        solvePythagButton.addActionListener(this);

        setFocusable(true);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 800);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //background
        g.setColor(blackboard);
        g.fillRect(0, 0, 800, 800);
        g.setColor(black);
        g.fillRect(0, 750, 800, 50);
        g.fillRect(0, 0, 5, 800);
        g.fillRect(0, 0, 800, 5);
        g.fillRect(795, 0, 5, 800);
        g.setColor(white);
        g.fillRoundRect(500, 780, 100, 7, 3, 3);

        g.setColor(black);
        g.drawString("Enter a radius:", 100, 198); //String, x and y location

        g.drawString("Enter a radius:", 100, 498);
        g.drawString("Enter a height:", 100, 548);//change

        g.drawString("Enter \'a\':", 500, 498);
        g.drawString("Enter \'b\':", 500, 548);

        g.drawString("x^2 \t +", 535, 220);
        g.drawString("x \t +", 610, 220);

        if(check == true){
            g.drawString("x1: " + sol1, 500, 275);
            g.drawString("x2: " + sol2, 600, 275);
        }else if (check == false){
            g.drawString("x1: Imaginary", 500, 275);
            g.drawString("x2: Imaginary", 600, 275);
        }

        g.drawString("Volume of a Sphere: " + volSphere, 100, 275);

        g.drawString("Volume of a Cylinder: " + volCyl, 100, 625);

        g.drawString("C: " + c, 500, 625);

        g.setColor(white);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g.drawString("√-1 2^3 ∑ Π", 100, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //change
        if (e.getSource() == solveQuadButton) {
            String aTxt2 = aInput2.getText();
            double a2 = Double.parseDouble(aTxt2);
            String bTxt2 = bInput2.getText();
            double b2 = Double.parseDouble(bTxt2);
            String cTxt2 = cInput2.getText();
            double c2 = Double.parseDouble(cTxt2);

            double det = Math.pow(b2, 2) - 4.0*a2*c2;
            if(det >= 0){
                double x1 = (-1.0*b2 + Math.sqrt(det))/(2*a2);
                double x2 = (-1.0*b2 - Math.sqrt(det))/(2*a2);
                if(x1 != x2){
                    sol1 = Math.round(x1);
                    sol2 = Math.round(x2);
                }else if (x1 == x2){
                    sol1 = Math.round(x1);
                    sol2 = Math.round(x2);
                }
                check = true;
            }else if(det < 0){
                check = false;
            }

            repaint();
        }
        if(e.getSource() == volSphereButton){
            String radiusTxt2 = radiusInput.getText();
            double radius2 = Double.parseDouble(radiusTxt2);
            volSphere = 4.0/3.0 * Math.PI * Math.pow(radius2, 3);

            repaint();
        }
        if(e.getSource() == volCylButton){
            String radiusTxt2 = radiusInput2.getText();
            double radius2 = Double.parseDouble(radiusTxt2);
            String heightTxt = heightInput.getText();
            double height = Double.parseDouble(heightTxt);
            volCyl = Math.PI * Math.pow(radius2, 2) * height;

            repaint();
        }
        if(e.getSource() == solvePythagButton){
            String aTxt = aInput.getText();
            double a = Double.parseDouble(aTxt);
            String bTxt = bInput.getText();
            double b = Double.parseDouble(bTxt);

            c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

            repaint();
        }
    }
}
