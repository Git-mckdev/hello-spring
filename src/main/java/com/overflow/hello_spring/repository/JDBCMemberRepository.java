package com.overflow.hello_spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

import com.overflow.hello_spring.domain.Member;

public class JDBCMemberRepository implements MemberRepository {
    
    private final DataSource dataSource;

    public JDBCMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Member save(Member member) {
        String sql = "INSERT INTO member(name) VALUES(?)";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, member.getName());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                member.setId(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = null;

        String sql = "SELECT * FROM member WHERE id = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return member != null ? Optional.of(member) : Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        Member member = null;

        String sql = "SELECT * FROM member WHERE name = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return member != null ? Optional.of(member) : Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();

        String sql = "SELECT * FROM member";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = getConnection();

            ps = con.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                members.add(member);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            close(con, ps, rs);
        }

        return members;
    }

    public void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        return DataSourceUtils.getConnection(dataSource);
    }
}
