package com.nslauncher.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String selectedVersion = "1.21.11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = findViewById(R.id.playButton);
        Button versions = findViewById(R.id.versionButton);
        Button settings = findViewById(R.id.settingsButton);

        play.setOnClickListener(v -> new AlertDialog.Builder(this)
            .setTitle("NS Launcher")
            .setMessage("Главный экран готов. Чтобы запускать Minecraft, нужно подключить игровой движок и загрузчик файлов. Это пока стартовая версия интерфейса.")
            .setPositiveButton("Понятно", null)
            .show());

        versions.setOnClickListener(v -> {
            String[] options = {"1.21.11", "1.21.10", "1.20.1", "Fabric (движок пока не подключён)"};
            new AlertDialog.Builder(this)
                .setTitle("Выбор версии")
                .setSingleChoiceItems(options, 0, (dialog, which) -> {
                    selectedVersion = options[which];
                    Toast.makeText(this, "Выбрано: " + selectedVersion, Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Отмена", null)
                .show();
        });

        settings.setOnClickListener(v -> new AlertDialog.Builder(this)
            .setTitle("Настройки")
            .setMessage("Версия интерфейса: 0.1\nПрофиль: локальный\nИгровой движок: ещё не подключён\n\nПамять и авторизацию добавим при интеграции игрового движка.")
            .setPositiveButton("ОК", null)
            .show());
    }
}
