package pro.ofitserov.msaaml.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pro.ofitserov.msaaml.model.ML;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class Dao {
    private static final Logger logger = LoggerFactory.getLogger(Dao.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ML> getMLList(String legalId, String fullName, String birthDate) {

        String sql = "SELECT * FROM msa WHERE passport = ? and UPPER(REPLACE(full_name, ' ', '')) = ? and date_of_birth = ?";

        List<ML> listML = jdbcTemplate.query(sql, new Object[]{legalId, fullName.replaceAll("\\s", "").toLowerCase(), birthDate}, new RowMapper<ML>() {
            public ML mapRow(ResultSet rs, int rowNum) throws SQLException {
                ML ml = new ML();
                ml.setLegalId(rs.getString("passport"));
                ml.setFullName(rs.getString("full_name"));
                ml.setBirthDate(rs.getString("date_of_birth"));
                return ml;
            }
        });

        return listML;
    }
}
