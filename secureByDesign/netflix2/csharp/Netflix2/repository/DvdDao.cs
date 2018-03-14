using System;
using System.Collections.Generic;

namespace Netflix2.repository
{
    public class DvdDao
    {
        public static IEnumerable<string> GetIdentifiers()
        {
            using (var cnx = DB.GetConnection())
            using (var rs = DB.ExecuteQuery("SELECT ID FROM DVDS WHERE ID > 0", cnx))
            {
                while (rs.Read())
                {
                    int id = (int)rs["ID"];
                    yield return id.ToString();
                }
            }
        }
    }
}