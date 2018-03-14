using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SQLite;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Netflix2.repository
{
    public class UserDao
    {
        /**
         * Register a user to the system.
         * The user identifier is unique.
         *
         * @param userId identifier of a user
         * @param password password
         * @return true if the user has been successfully registered, false otherwise
         */
        public static bool Register(string userId, string password)
        {
            return DB.Insert($"INSERT INTO USERS(ID, PASSWORD) values('{userId}', '{password}')");
        }

    }

    public static class DB
    {
        public static bool Insert(string query)
        {
            using (var cnx = GetConnection())
            {
                cnx.Open();
                using (var cmd = cnx.CreateCommand())
                {
                    cmd.CommandText = query;
                    var result = cmd.ExecuteNonQuery();
                    return result == 1;
                }
            }
        }

        private static SQLiteConnection GetConnection()
        {
            var connectionString = ConfigurationManager.ConnectionStrings["Netflix2"].ConnectionString;
            return new SQLiteConnection(connectionString);
        }
    }
}
