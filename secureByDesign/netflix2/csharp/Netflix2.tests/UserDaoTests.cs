using Netflix2.repository;
using NFluent;
using NUnit.Framework;

namespace Netflix2.tests
{
    [TestFixture]
    public class UserDaoTests
    {
        [Test]
        public void Insert_User()
        {
            var result = UserDao.Register("toto", "pwd");
            Check.That(result).IsEqualTo(true);
        }

        [Test]
        public void Exist_User()
        {
            UserDao.Register("totoExist", "pwd");
            var actual = UserDao.Exist("totoExist", "pwd");
            Check.That(actual).IsTrue();
        }

        [Test]
        public void Exist_NoUser()
        {
            var actual = UserDao.Exist("totoZorglub", "pwd");
            Check.That(actual).IsFalse();

        }

    }
}
