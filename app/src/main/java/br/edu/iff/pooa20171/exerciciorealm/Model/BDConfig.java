package br.edu.iff.pooa20171.exerciciorealm.Model;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import android.content.Context;

public class BDConfig extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Realm.init(getApplicationContext());

        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(this);
        builder.name("exercicioR.realm");
        builder.schemaVersion(0);
        builder.deleteRealmIfMigrationNeeded();
        RealmConfiguration realmConfiguration = builder.build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}