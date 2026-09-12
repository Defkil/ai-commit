package com.github.defkil.aicommit.handlers;


import com.intellij.openapi.vcs.CheckinProjectPanel;
import com.intellij.openapi.vcs.checkin.CheckinHandler;
import com.intellij.openapi.vcs.ui.RefreshableOnComponent;
import com.intellij.ui.NonFocusableCheckBox;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class MyCommitHandler extends CheckinHandler {
    private final CheckinProjectPanel panel;

    public MyCommitHandler(CheckinProjectPanel panel) {
        this.panel = panel;
    }

    private final NonFocusableCheckBox myButton = new NonFocusableCheckBox("Generate AI Commit Message");

    @Override
    public RefreshableOnComponent getBeforeCheckinConfigurationPanel() {
        JButton myButton = new JButton("Generate Message");
        myButton.addActionListener(e -> {
            panel.setCommitMessage("Hello World");
        });

        return new RefreshableOnComponent() {
            @Override
            public JComponent getComponent() {
                return myButton;
            }

            @Override
            public void refresh() {
                // Sie können dies leer lassen, es sei denn, Sie möchten eine spezielle Aktion durchführen, wenn das UI aktualisiert wird.
            }

            @Override
            public void saveState() {
                // Sie können dies leer lassen, es sei denn, Sie möchten eine spezielle Aktion durchführen, wenn das UI seinen Zustand speichert.
            }

            @Override
            public void restoreState() {
                // Sie können dies leer lassen, es sei denn, Sie möchten eine spezielle Aktion durchführen, wenn das UI seinen Zustand wiederherstellt.
            }
        };
    }


    @Override
    public ReturnResult beforeCheckin() {
        if (myButton.isSelected()) {
            panel.setCommitMessage("Hello World");
        }
        return super.beforeCheckin();
    }
}