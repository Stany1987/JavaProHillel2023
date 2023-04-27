package org.ua.javaPro.berezhnoy.hillelHomeWork20JDBC;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
public class HeroDaoImp implements HeroDao {
    private final DataSource dataSource;

    public List<Hero> findAll() {
        var sql = "SELECT * FROM heroes";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    private ArrayList<Hero> mapHeroes(ResultSet result) throws SQLException {
        var heroes = new ArrayList<Hero>();
        while (result.next()) {
            heroes.add(Hero.builder()
                    .id(result.getLong("id"))
                    .name(result.getString("name"))
                    .gender(result.getString("gender"))
                    .eyeColor(result.getString("eye_color"))
                    .race(result.getString("race"))
                    .hairColor(result.getString("hair_color"))
                    .height(result.getDouble("height"))
                    .publisher(result.getString("publisher"))
                    .skinColor(result.getString("skin_color"))
                    .alignment(result.getString("aligment"))
                    .weight(result.getInt("weight"))
                    .build());
        }
        return heroes;
    }

    @Override
    public List<Hero> findByName(String name) {
        var sql = "select * from heroes where name = '" + name + "'";
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            var result = statement.executeQuery(sql);
            return mapHeroes(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Hero hero) {
        var sql = "insert into heroes (id, name, gender, eye_color, race, hair_color,height,publisher,skin_color, aligment, weight) "
                + "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (var connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            preparedStatementForHero(statement, hero);

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void preparedStatementForHero(PreparedStatement statement, Hero hero) throws SQLException {
        statement.setLong(1, hero.getId());
        statement.setString(2, hero.getName());
        statement.setString(3, hero.getGender());
        statement.setString(4, hero.getEyeColor());
        statement.setString(5, hero.getRace());
        statement.setString(6, hero.getHairColor());
        statement.setDouble(7, hero.getHeight());
        statement.setString(8, hero.getPublisher());
        statement.setString(9, hero.getSkinColor());
        statement.setString(10, hero.getAlignment());
        statement.setDouble(11, hero.getWeight());
    }

    @Override
    public void update(Hero hero) {
        var sql = "update heroes set id=?, name=?, gender=?, eye_color=?, race=?, hair_color=?, height=?, publisher=?, " +
                "skin_color=?, aligment=?, weight=? where id=?";
        try (var connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            preparedStatementForHero(statement, hero);
            statement.setLong(12, hero.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public boolean delete(Long id) {
        var sql = "delete from heroes where id=?";
        try (var connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            int count = statement.executeUpdate();
            return count > 0;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
