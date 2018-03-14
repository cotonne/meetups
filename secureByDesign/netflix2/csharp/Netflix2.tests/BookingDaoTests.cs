using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Netflix2.repository;
using NFluent;
using NUnit.Framework;

namespace Netflix2.tests
{
    [TestFixture]
    public class BookingDaoTests
    {
        [Test]
        public void Book_Ok()
        {
            var userId = "User" + Guid.NewGuid();
            UserDao.Register(userId, "pwd");
            var actual = BookingDao.Book("3", 10, userId);
            Check.That(actual).IsTrue();
        }
    }
}
