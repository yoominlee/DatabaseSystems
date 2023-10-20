import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;

public class EventBookingPage extends JFrame {
    private JLabel selectedMembersLabel = new JLabel();

    public EventBookingPage() {
        setTitle("Event Booking Page");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 2)); // Set grid layout with any number of rows and 2 columns
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Event name
        JLabel eventNameLabel = new JLabel("Event Name:");
        JTextField eventNameField = new JTextField();

        // Description
        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        // Add components to the panel.
        panel.add(eventNameLabel);
        panel.add(eventNameField);
        panel.add(descriptionLabel);
        panel.add(descriptionField);

        // ...

        JPanel memberSelectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton selectMembersButton = new JButton("Select Members");
        selectMembersButton.addActionListener(e -> {
            MemberSelectionPage memberSelectionPage = new MemberSelectionPage(this);
            memberSelectionPage.setVisible(true);
        });

        selectedMembersLabel.setText("No members selected.");
        memberSelectionPanel.add(selectMembersButton);
        memberSelectionPanel.add(selectedMembersLabel);

        panel.add(new JLabel("Join Request Member:"));
        panel.add(memberSelectionPanel);

        // ...

        // Start and end time
        JSpinner startTimeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner endTimeSpinner = new JSpinner(new SpinnerDateModel());

        JLabel startTimeLabel = new JLabel("Start Time:");
        JLabel endTimeLabel = new JLabel("End Time:");

        // Add components to the panel.
        panel.add(startTimeLabel);
        panel.add(startTimeSpinner);
        panel.add(endTimeLabel);
        panel.add(endTimeSpinner);

        JPanel selections = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox allDayCheckBox = new JCheckBox("All Day");
        JCheckBox reminderCheckBox = new JCheckBox("Remind please");
        selections.add(allDayCheckBox);
        selections.add(reminderCheckBox);

        allDayCheckBox.setSelected(false); // Default to false.

        String[] importanceLevels = { "High", "Medium", "Low" };
        JComboBox<String> importanceSelectionBox = new JComboBox<>(importanceLevels);

        String[] privacyOptions = { "Public", "Private" };
        JComboBox<String> privacySelectionBox = new JComboBox<>(privacyOptions);

        JLabel allDayLabel = new JLabel("All Day & Reminder");
        JLabel importanceLevelLabel = new JLabel("Importance Level ");
        JLabel privacyOptionsLabel = new JLabel("Privacy Options ");

        // Add components to the panel.
        panel.add(allDayLabel);
        panel.add(selections);
        panel.add(importanceLevelLabel);
        panel.add(importanceSelectionBox);
        panel.add(privacyOptionsLabel);
        panel.add(privacySelectionBox);

        JButton createEventButton = new JButton("Create Event");
        createEventButton.addActionListener(e -> {
            // Add action code later.
        });

        panel.add(createEventButton, BorderLayout.SOUTH);

        JButton modifyEventButton = new JButton("Modify Event");
        modifyEventButton.addActionListener(e -> {
            // Add action code later.
        });

        panel.add(modifyEventButton, BorderLayout.SOUTH);

        add(panel);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            EventBookingPage frame = new EventBookingPage();
            frame.setVisible(true);
        });
    }

    public void setSelectedMembers(List<String> availableMembers) {
        selectedMembersLabel.setText("Selected members: " + String.join(", ", availableMembers));
    }
}

class MemberSelectionPage extends JFrame {

    private final EventBookingPage eventBookingPage;
    private final JList<String> memberList;

    // public MemberSelectionPage(EventBookingPage eventBookingPage) {
    // this.eventBookingPage = eventBookingPage;

    // setTitle("Select Members");
    // setSize(400, 300);
    // setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose this frame when
    // closed.

    // String[] members = { "Member1", "Member2", "Member3" }; // replace with your
    // member names
    // memberList = new JList<>(members);
    // memberList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    // JScrollPane listScroller = new JScrollPane(memberList);
    // listScroller.setPreferredSize(new Dimension(250, 80));

    // JPanel panel = new JPanel(new BorderLayout());
    // panel.add(listScroller, BorderLayout.CENTER);

    // JButton checkAvailabilityButton = new JButton("Check Availability");
    // checkAvailabilityButton.addActionListener(e -> checkAvailability());
    // panel.add(checkAvailabilityButton, BorderLayout.SOUTH);

    // add(panel);
    // }

    public MemberSelectionPage(EventBookingPage eventBookingPage) {
        this.eventBookingPage = eventBookingPage;

        setTitle("Select Members");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose this frame when closed.

        String[] members = { "Member1", "Member2", "Member3" }; // replace with your member names
        memberList = new JList<>(members);
        memberList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane listScroller = new JScrollPane(memberList); // Make sure spelling matches here

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(listScroller, BorderLayout.CENTER); // And here

        JButton checkAvailabilityButton = new JButton("Check Availability");
        checkAvailabilityButton.addActionListener(e -> checkAvailability());
        panel.add(checkAvailabilityButton, BorderLayout.SOUTH);

        add(panel);
    }

    private boolean isMemberAvailable(String memberName) {
        // Simulate checking if a member is available.
        // This will randomly determine availability.
        return Math.random() < 0.5;
    }

    private void checkAvailability() {
        List<String> selectedMembers = memberList.getSelectedValuesList();
        List<String> availableMembers = new ArrayList<>();

        for (String member : selectedMembers) {
            if (isMemberAvailable(member)) {
                availableMembers.add(member);
            }
        }

        JOptionPane.showMessageDialog(this, "Available Members:" + String.join(", ", availableMembers));

        eventBookingPage.setSelectedMembers(availableMembers);
        dispose();
    }

}
