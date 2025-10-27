package org.example.TASK5.view;

import org.example.TASK5.model.DrawShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class PaintSurface extends JComponent {

    private final List<DrawShape> shapes = new ArrayList<>();
    private int shapeType;
    private Point startDrag;
    private Point endDrag;

    private float hue = 0f;

    public PaintSurface() {
        shapeType = 0;
        super.setPreferredSize(new Dimension(400, 400));

        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                DrawShape shape = DrawShape.newInstance(shapeType);
                shape.setStartPoint(startDrag);
                shape.setEndPoint(endDrag);
                shapes.add(shape);
                startDrag = null;
                endDrag = null;
                repaint();
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY());
                repaint();
            }
        });

        Timer timer = new Timer(50, e -> {
            hue += 0.01f;
            if (hue > 1f) hue = 0f;
            repaint();
        });
        timer.start();
    }

    public void setShapeType(int type) {
        this.shapeType = type;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.BLACK);
        g2.fillRect(0, 0, getWidth(), getHeight());

        paintBackgroundGrid(g2);

        for (DrawShape s : shapes) {
            Shape shape = s.getShape();

            float localHue = (hue + shapes.indexOf(s) * 0.15f) % 1f;
            Color neon = Color.getHSBColor(localHue, 1f, 1f);

            for (int i = 10; i > 0; i--) {
                float alpha = 0.08f * i;
                g2.setStroke(new BasicStroke(i * 2f));
                g2.setColor(new Color(neon.getRed() / 255f, neon.getGreen() / 255f, neon.getBlue() / 255f, alpha));
                g2.draw(shape);
            }

            g2.setColor(neon);
            g2.fill(shape);
        }

        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.GRAY);
            DrawShape shape = DrawShape.newInstance(shapeType);
            g2.draw(shape.getShape(startDrag, endDrag));
        }
    }

    private void paintBackgroundGrid(Graphics2D g2) {
        g2.setPaint(new Color(50, 50, 50)); // темно-сіра сітка
        for (int i = 0; i < getSize().width; i += 10)
            g2.draw(new Line2D.Float(i, 0, i, getSize().height));
        for (int i = 0; i < getSize().height; i += 10)
            g2.draw(new Line2D.Float(0, i, getSize().width, i));
    }

    public void clearShapes() {
        shapes.clear();
        repaint();
    }
}