package ResourceLoading;

import Database.JoConnect;

public class ConnectMysql {

    public boolean getConnect() {
        JoConnect connect = new JoConnect();
        return connect.getConnectionDefault() != null;
    }
}
