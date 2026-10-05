import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentGUI extends JFrame {

    private final JTextField searchField;
    private final JTextArea resultArea;
    private final ArrayList<Component> components;

    public ComponentGUI() {

        components = ComponentDatabase.getComponents();

        setTitle("Electronics Component Identifier");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        // =========================
        // TITLE
        // =========================

        JLabel titleLabel = new JLabel(
                "ELECTRONICS COMPONENT IDENTIFIER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // =========================
        // SEARCH PANEL
        // =========================

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel nameLabel = new JLabel("Component Name:");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));

        searchField = new JTextField(25);
        searchField.setFont(new Font("Arial", Font.PLAIN, 15));

        JButton searchButton = new JButton("SEARCH");
        JButton viewAllButton = new JButton("VIEW ALL");
        JButton clearButton = new JButton("CLEAR");

        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        viewAllButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));

        searchPanel.add(nameLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(viewAllButton);
        searchPanel.add(clearButton);

        // Put search panel below title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(searchPanel, BorderLayout.SOUTH);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        // =========================
        // RESULT AREA
        // =========================

        resultArea = new JTextArea();

        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
        resultArea.setEditable(false);
        resultArea.setLineWrap(false);
        resultArea.setWrapStyleWord(false);

        resultArea.setBorder(
                BorderFactory.createTitledBorder("Component Details")
        );

        JScrollPane scrollPane = new JScrollPane(resultArea);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // =========================
        // BUTTON ACTIONS
        // =========================

        searchButton.addActionListener(e -> searchComponent());

        viewAllButton.addActionListener(e -> showAllComponents());

        clearButton.addActionListener(e -> {
            searchField.setText("");
            resultArea.setText("");
        });

        // Press ENTER to search
        searchField.addActionListener(e -> searchComponent());

        // =========================
        // WINDOW
        // =========================

        add(mainPanel);

        setVisible(true);
    }

    // =====================================================
    // SEARCH COMPONENT
    // =====================================================

    private void searchComponent() {

        String searchName = searchField.getText().trim();

        if (searchName.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a component name.",
                    "Input Required",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        boolean found = false;

        for (Component component : components) {

            if (component.name.equalsIgnoreCase(searchName)) {

                displayComponent(component);

                found = true;
                break;
            }
        }

        if (!found) {

            resultArea.setText(
                    "\n\n"
                            + "============================================================\n"
                            + "                    COMPONENT NOT FOUND\n"
                            + "============================================================\n\n"
                            + "No component named \"" + searchName + "\" was found.\n\n"
                            + "Please check the component name and try again.\n\n"
                            + "You can click VIEW ALL to see all available components."
            );
        }
    }

    // =====================================================
    // DISPLAY SINGLE COMPONENT
    // =====================================================

    private void displayComponent(Component component) {

        String output = "\n" +
                "============================================================\n" +
                "                    COMPONENT DETAILS\n" +
                "============================================================\n\n" +
                String.format("%-18s : %s%n", "Name", component.name) +
                String.format("%-18s : %s%n", "Category", component.category) +
                String.format("%-18s : %s%n", "Function", component.function) +
                String.format("%-18s : %s%n", "Pins", component.pins) +
                String.format("%-18s : %s%n", "Applications", component.applications) +
                String.format("%-18s : %s%n", "Advantages", component.advantages) +
                "\n" +
                "============================================================\n";

        resultArea.setText(output);

        resultArea.setCaretPosition(0);
    }

    // =====================================================
    // VIEW ALL COMPONENTS
    // =====================================================

    private void showAllComponents() {

        StringBuilder output = new StringBuilder();

        output.append("\n");
        output.append("============================================================\n");
        output.append("              AVAILABLE ELECTRONICS COMPONENTS\n");
        output.append("============================================================\n\n");

        for (Component component : components) {

            output.append("• ")
                    .append(component.name)
                    .append("  [")
                    .append(component.category)
                    .append("]\n");
        }

        output.append("\n");
        output.append("============================================================\n");
        output.append("Total Components : ")
                .append(components.size())
                .append("\n");
        output.append("============================================================\n");

        resultArea.setText(output.toString());

        resultArea.setCaretPosition(0);
    }

    // =====================================================
    // MAIN METHOD
    // =====================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(ComponentGUI::new);
    }
}