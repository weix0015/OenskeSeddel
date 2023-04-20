package com.example.oenskeseddel.Repository;

import com.example.oenskeseddel.Model.Ønske;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ØnskeRepo {
    @Autowired
    JdbcTemplate template;


    // This method will select the whole data from the database.
    public List<Ønske> fetchAll() {
        String sql = "SELECT * FROM oenske";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        return template.query(sql, rowMapper);
    }

    public List<Ønske> fetchUserWishes(int id) {
        String sql = "SELECT * FROM oenske WHERE bruger_id = ?";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        return template.query(sql, rowMapper, id);
    }
    // The add method, will add the new info to the data.
    public void addØnske(Ønske ø) {
        String sql = "INSERT INTO oenske(navn, beskrivelse, link, bruger_id) VALUES(?,?,?,?)";
        template.update(sql, ø.getNavn(), ø.getBeskrivelse(), ø.getLink(), ø.getBruger_id());
    }
      // This method will finde the ønske.

    public Ønske findeØnske(int id) {
        String sql = "SELECT * FROM oenske WHERE id = ?";
        RowMapper<Ønske> rowMapper = new BeanPropertyRowMapper<>(Ønske.class);
        Ønske ønske = template.queryForObject(sql, rowMapper, id);
        return ønske;
    }
  // This method will delete the ønske.
    public Boolean sletOenske(int id) {
        String sql = "DELETE FROM oenske WHERE id = ?";
        return template.update(sql, id) > 0;
    }

    // This method will update the ønske.
    public void opdaterOenske(int id, Ønske ø) {
        String sql = "UPDATE oenske SET navn = ?, beskrivelse = ?, link = ? WHERE id = ?";
        template.update(sql, ø.getNavn(), ø.getBeskrivelse(), ø.getLink(), ø.getId());
    }
}
