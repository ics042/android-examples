package com.tsun.framework.greendao;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.tsun.framework.App;
import com.tsun.framework.R;

import org.greenrobot.greendao.query.Query;

public class NoteActivity extends AppCompatActivity {

    private RecyclerView rvNote;

    private NoteDao noteDao;
    private Query<Note> notesQuery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_main);
        rvNote = (RecyclerView)findViewById(R.id.rv_note);
        // get the note DAO
        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        noteDao = daoSession.getNoteDao();

        // query all notes, sorted a-z by their text
        notesQuery = noteDao.queryBuilder().orderAsc(NoteDao.Properties.Name).build();
        updateNotes();
    }

    private void updateNotes() {
    }
}
