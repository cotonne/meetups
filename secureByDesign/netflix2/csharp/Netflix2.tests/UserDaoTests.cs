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
    public class UserDaoTests
    {
        [Test]
        public void Test1()
        {
            var result = UserDao.Register("toto", "pwd");
            Check.That(result).IsEqualTo(true);
        }
    }
}
