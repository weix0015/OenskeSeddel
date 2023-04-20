package com.example.oenskeseddel.Repository;

import com.example.oenskeseddel.Model.Bruger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrugerRepo {

    @Autowired
    JdbcTemplate template;

    // metode til at oprette bruger
    public void addBruger(Bruger A) {
        String sql = "INSERT INTO bruger(fornavn, efternavn, brugernavn, bruger_email)" +
                "VALUES(?, ?, ?, ?)";
        template.update(sql, A.getFornavn(), A.getEfternavn(),
                A.getBrugernavn(), A.getBruger_email());

    }

    // metode til at finde bruger, så tabellen kun viser den bestemte bruges ønskeseddel tabel
    public Bruger findeBrugernavn(String brugernavn) {
        String sql = "SELECT * FROM bruger WHERE brugernavn = ?";
        RowMapper<Bruger> rowMapper = new BeanPropertyRowMapper<>(Bruger.class);
        List<Bruger> bruger = template.query(sql, rowMapper, brugernavn);
        if (bruger.size() == 1) {
            return bruger.get(0);
        } else {
            return null;
        }
    }
}
