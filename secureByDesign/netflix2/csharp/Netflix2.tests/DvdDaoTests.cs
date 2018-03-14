using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Netflix2.repository;
using NFluent;
using NUnit.Framework;

namespace Netflix2.tests
{
    [TestFixture]
    public class DvdDaoTests
    {
        [Test]
        public void GetIdentifiers_Ok()
        {
            var actual = DvdDao.GetIdentifiers();
            Check.That(actual.Count()).IsEqualTo(8);
        }
    }
}
