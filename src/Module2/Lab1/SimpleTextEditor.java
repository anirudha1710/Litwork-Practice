package Module2.Lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SimpleTextEditor {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();

        Scanner scanner = new Scanner(System.in);
        String[] inputCommands = scanner.nextLine().trim().split(",");

        for (String command : inputCommands) {
            String[] parts = command.split(" ");
            String op = parts[0];

            switch (op) {
                case "1" -> customStack.insert(parts[1]);
                case "2" -> customStack.delete(Integer.parseInt(parts[1]));
                case "3" -> customStack.get(Integer.parseInt(parts[1]));
                case "4" -> customStack.undo();
            }
        }
    }


    static class CustomStack {
        private final StringBuilder text;
        private final List<Command> commands;

        public CustomStack() {
            this.text = new StringBuilder();
            this.commands = new ArrayList<>();
        }

        public void insert(String value) {
            text.append(value);
            commands.add(new Command("delete", value.length()));
        }

        public void delete(int value) {
            String deleted = text.substring(text.length() - value);
            text.delete(text.length() - value, text.length());
            commands.add(new Command("insert", deleted));
        }

        public void get(int value) {
            char character = text.charAt(value - 1);
            System.out.println(character);
        }

        public void undo() {
            if (!commands.isEmpty()) {
                Command lastCommand = commands.remove(commands.size() - 1);
                if (lastCommand.operation.equals("delete")) {
                    text.append(lastCommand.value);
                } else if (lastCommand.operation.equals("insert")) {
                    text.delete(text.length() - lastCommand.value.length(), text.length());
                }
            }
        }

        private static class Command {
            private final String operation;
            private final String value;

            public Command(String operation, int value) {
                this.operation = operation;
                this.value = String.valueOf(value);
            }

            public Command(String operation, String value) {
                this.operation = operation;
                this.value = value;
            }
        }
    }
}
