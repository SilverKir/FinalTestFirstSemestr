package client;

import Models.Model;
import Presenters.Presenter;
import view.View;

public class App {
    Presenter p;
    View ui;
    Model model;

    public App() {
        ui = new ConsoleView();
        model = new Model("MyAnimals");
        p = new Presenter(ui, model);
    }

    public void start()  {
        StringBuilder sb = new StringBuilder()
                .append("\n ==MENU== \n")
                .append("1 - add animal\n")
                .append("2 - show animals in registry\n")
                .append("3 - add command\n")
                .append("4 - sort by birthday\n")
                .append("0 - exit\n");


        while (true) {
            ui.set(sb.toString());
            switch (ui.get()) {
                case "1":
                    p.append();
                    break;
                case "2":
                    p.show();
                    break;
                case "3":
                    p.addCommand();
                    break;
                case "4":
                    p.showSorted();
                    break;
                case "0":
                    return;
            }
        }
    }
}
