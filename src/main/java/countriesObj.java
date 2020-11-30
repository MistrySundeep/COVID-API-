import java.util.Date;

public class countriesObj {
    public String country;
    public int recovered;
    public int critical;
    public String code;
    public Date lUpdate;
    public Date lChange;
    public int confirmed;
    public int deaths;

    public countriesObj(String country, int recovered, int critical, String code, Date lUpdate, Date lChange, int confirmed, int deaths) {
        this.country = country;
        this.recovered = recovered;
        this.critical = critical;
        this.code = code;
        this.lUpdate = lUpdate;
        this.lChange = lChange;
        this.confirmed = confirmed;
        this.deaths = deaths;
    }
}


//[
//        {
//        "country": "Poland",
//        "recovered": 516636,
//        "code": "PL",
//        "critical": 2106,
//        "latitude": 51.919438,
//        "lastUpdate": "2020-11-28T02:45:05+01:00",
//        "lastChange": "2020-11-27T10:57:21+01:00",
//        "confirmed": 958416,
//        "deaths": 16147,
//        "longitude": 19.145136
//        }
//]
