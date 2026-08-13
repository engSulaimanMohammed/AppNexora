package org.example.Utils;

import org.example.Entities.PerformanceHR;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PerformanceChartPanelHR extends JPanel {

    private List<PerformanceHR> data;

    public PerformanceChartPanelHR() {

        setPreferredSize(
                new Dimension(760, 360)
        );

        setBackground(Color.WHITE);
    }

    public void setData(List<PerformanceHR> data) {

        this.data = data;

        repaint();
    }

    private Color getPerformanceColor(double score) {

        if (score >= 90) {
            return new Color(34, 197, 94);
        }

        if (score >= 80) {
            return new Color(59, 130, 246);
        }

        if (score >= 70) {
            return new Color(234, 179, 8);
        }

        if (score >= 60) {
            return new Color(249, 115, 22);
        }

        return new Color(239, 68, 68);
    }

    @Override
    protected void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        Graphics2D g =
                (Graphics2D) graphics.create();

        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        int left = 65;
        int right = getWidth() - 30;
        int top = 30;
        int bottom = getHeight() - 55;

        int height = bottom - top;
        int width = right - left;

        // Grid
        g.setColor(
                new Color(225, 230, 238)
        );

        for (int i = 0; i <= 5; i++) {

            int y =
                    bottom - i * height / 5;

            g.drawLine(
                    left,
                    y,
                    right,
                    y
            );

            g.setColor(
                    new Color(80, 90, 105)
            );

            g.drawString(
                    (i * 20) + "%",
                    20,
                    y + 5
            );

            g.setColor(
                    new Color(225, 230, 238)
            );
        }

        if (data == null || data.isEmpty()) {

            g.setColor(Color.GRAY);

            g.drawString(
                    "No performance evaluations.",
                    left + 50,
                    getHeight() / 2
            );

            g.dispose();
            return;
        }

        // Draw lines
        for (int i = 0;
             i < data.size() - 1;
             i++) {

            PerformanceHR first =
                    data.get(i);

            PerformanceHR second =
                    data.get(i + 1);

            int x1 =
                    left + i * width /
                            Math.max(
                                    1,
                                    data.size() - 1
                            );

            int x2 =
                    left + (i + 1) * width /
                            Math.max(
                                    1,
                                    data.size() - 1
                            );

            int y1 =
                    bottom -
                            (int)
                                    (first.getScore()
                                            / 100
                                            * height);

            int y2 =
                    bottom -
                            (int)
                                    (second.getScore()
                                            / 100
                                            * height);

            g.setStroke(
                    new BasicStroke(4)
            );

            g.setColor(
                    getPerformanceColor(
                            second.getScore()
                    )
            );

            g.drawLine(
                    x1,
                    y1,
                    x2,
                    y2
            );
        }

        // Points
        for (int i = 0;
             i < data.size();
             i++) {

            PerformanceHR performance =
                    data.get(i);

            int x =
                    left + i * width /
                            Math.max(
                                    1,
                                    data.size() - 1
                            );

            int y =
                    bottom -
                            (int)
                                    (performance.getScore()
                                            / 100
                                            * height);

            g.setColor(
                    getPerformanceColor(
                            performance.getScore()
                    )
            );

            g.fillOval(
                    x - 6,
                    y - 6,
                    12,
                    12
            );

            g.setColor(
                    new Color(35, 45, 60)
            );

            g.drawString(
                    performance.getPeriod(),
                    x - 12,
                    bottom + 25
            );

            g.drawString(
                    String.format(
                            "%.0f%%",
                            performance.getScore()
                    ),
                    x - 15,
                    y - 12
            );
        }

        g.dispose();
    }
}
