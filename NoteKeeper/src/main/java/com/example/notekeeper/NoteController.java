package com.example.notekeeper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {
    @FXML
    private ListView<Note> listView;
    @FXML
    private TextField titleField;
    @FXML
    private TextArea contentArea;

    private ObservableList<Note> noteList;

    public void initialize() {
        noteList = FXCollections.observableArrayList();
        listView.setItems(noteList);
    }

    @FXML
    public void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();
        Note note = new Note(title, content);
        noteList.add(note);
        clearFields();
    }

    @FXML
    public void deleteNote() {
        Note selectedNote = listView.getSelectionModel().getSelectedItem();
        noteList.remove(selectedNote);
    }

    @FXML
    public void showNote() {
        Note selectedNote = listView.getSelectionModel().getSelectedItem();
        if (selectedNote != null) {
            titleField.setText(selectedNote.getTitle());
            contentArea.setText(selectedNote.getContent());
        }
    }

    private void clearFields() {
        titleField.clear();
        contentArea.clear();
    }
}
