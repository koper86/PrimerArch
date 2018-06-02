package pl.koper.primerarch.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import pl.koper.primerarch.model.Primer;
import pl.koper.primerarch.model.User;
import pl.koper.primerarch.util.ConnectionProvider;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimerDAOImpl implements PrimerDAO {

    private static final String CREATE_PRIMER = "INSERT INTO primer(sequence, description, user_id, date, up_vote, down_vote) "
            + "VALUES(:sequence, :description, :user_id, :date, :up_vote, :down_vote);";

    private static final String READ_ALL_PRIMERS =
            "SELECT user.user_id, username, email, is_active, password, primer_id, sequence, description, date, up_vote, down_vote" +
                    " FROM primer LEFT JOIN user ON primer.user_id = user.user_id;";

    private NamedParameterJdbcTemplate template;

    public PrimerDAOImpl() {
        this.template = new NamedParameterJdbcTemplate(ConnectionProvider.getDataSource());
    }

    @Override
    public Primer create(Primer primer) {

        Primer resultPrimer = new Primer(primer);
        KeyHolder holder = new GeneratedKeyHolder();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("sequence", primer.getSequence());
        paramMap.put("description", primer.getDescription());
        paramMap.put("user_id", primer.getUser().getId());
        paramMap.put("date", primer.getTimestamp());
        paramMap.put("up_vote", primer.getUpVote());
        paramMap.put("down_vote", primer.getDownVote());
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        int update = template.update(CREATE_PRIMER, paramSource, holder);
        if(update>0) {
            resultPrimer.setId((Long) holder.getKey());
        }
        return resultPrimer;
    }

    @Override
    public Primer read(Long primaryKey) {
        return null;
    }

    @Override
    public boolean update(Primer updateObject) {
        return false;
    }

    @Override
    public boolean delete(Long key) {
        return false;
    }

    @Override
    public List<Primer> getAll() {
        List<Primer> primers = template.query(READ_ALL_PRIMERS, new PrimerRowMapper());
        return primers;
    }
    private class PrimerRowMapper implements RowMapper<Primer> {
        @Override
        public Primer mapRow(ResultSet resultSet, int i) throws SQLException {
            Primer primer = new Primer();
            primer.setId(resultSet.getLong("primer_id"));
            primer.setSequence(resultSet.getString("sequence"));
            primer.setDescription(resultSet.getString("description"));
            primer.setUpVote(resultSet.getInt("up_vote"));
            primer.setDownVote(resultSet.getInt("down_vote"));
            primer.setTimestamp(resultSet.getTimestamp("date"));
            User user = new User();
            user.setId(resultSet.getLong("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            primer.setUser(user);
            return primer;
        }
    }
}
