package ro.ase.acs;

import ro.ase.acs.contracts.Close;
import ro.ase.acs.contracts.Create;
import ro.ase.acs.contracts.Insert;
import ro.ase.acs.contracts.Read;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
        Create create = (Create) Class.forName("ro.ase.acs.CreateDB").getDeclaredConstructor().newInstance();
        Insert insert = (Insert) Class.forName("ro.ase.acs.InsertDB").getDeclaredConstructor().newInstance();
        Read read = (Read) Class.forName("ro.ase.acs.ReadDB").getDeclaredConstructor().newInstance();
        Close close = (Close) Class.forName("ro.ase.acs.CloseDB").getDeclaredConstructor().newInstance();

        Orchestrator orchestrator = new Orchestrator(create, insert, read, close);
        orchestrator.executeSQL(create, insert, read, close);
        orchestrator.executeNoSQL(create, insert, read, close);
    }
}
