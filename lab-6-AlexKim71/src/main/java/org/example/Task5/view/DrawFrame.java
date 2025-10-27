package org.example.Task5.view;

import org.example.Task5.model.DrawShape;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Головне вікно програми. Фрейм (клас JFrame) є контейнером верхнього рівня
 */
public class DrawFrame extends JFrame {

    // Область для малювання фігур
    private PaintSurface surface;

    // У конструкторі створюємо GUI
    public DrawFrame(String title) {


        super(title);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        this.setLayout(new BorderLayout());

        // Додаємо верхню панель із трьома кнопками
        this.add(setButtonPanel(), BorderLayout.NORTH);

        // Створюємо об'єкт області малювання
        surface = new PaintSurface();

        // Додаємо область для малювання фігур у фрейм
        this.add(surface, BorderLayout.CENTER);

        // Цей метод змінює розмір кадру так

        this.pack();

        // "Показує" фрейм на екрані (встановлюємо видимість фрейму)
        this.setVisible(true);
    }


    private JPanel setButtonPanel() {

        // Створюємо панель для кнопок
        JPanel buttonPanel = new JPanel(true);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        // Колір фону панелі
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));


        BigTextButton rect = new BigTextButton("Rectangle");


        rect.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_RECTANGLE);
        });
        // додаємо першу кнопку на верхню панель
        buttonPanel.add(rect);

        // 2. Кнопка для закругленого прямокутника
        BigTextButton rounded_rect = new BigTextButton("Rounded rect.");
        rounded_rect.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT);
        });
        buttonPanel.add(rounded_rect);

        BigTextButton ellipse = new BigTextButton("Ellipse");
        ellipse.addActionListener(e -> {
            surface.setShapeType(DrawShape.SHAPE_ELLIPSE);
        });
        buttonPanel.add(ellipse);

        BigTextButton clear = new BigTextButton("Clear");
        clear.addActionListener(e -> surface.clearShapes());
        buttonPanel.add(clear);

        return buttonPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawFrame("Paint App"));
    }

}