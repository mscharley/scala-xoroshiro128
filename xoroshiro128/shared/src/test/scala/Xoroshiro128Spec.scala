import com.mscharley.random._
import org.scalatest.FlatSpec

// scalastyle:off magic.number
class Xoroshiro128Spec extends FlatSpec {
  def checkSequence(lo : Long, high : Long)(values : Long*) : Unit = {
    val sm = xoroshiro128(lo, high)
    assert(sm.take(values.length).toList == values)
  }

  "xoroshiro128::next()" should "calculate the right sequence of numbers for a seed of -4823001311516472710, 5949705871595575025" in
    checkSequence(-4823001311516472710L, 5949705871595575025L)(
      1126704560079102315L,
      8796220148548794092L,
      -4351969099738545414L,
      1115233890897963686L,
      -341761134134357137L,
      561071025051741906L,
      7204848339415919354L,
      -5077512656280648866L,
      -7692946770369052564L,
      -5063691591573174986L,
      -8897635170497897013L,
      -4199644625846217191L,
      -3544348651434211969L,
      -8079455476894169506L,
      2282080123371869556L,
      911121917961546834L,
      6723482648633717420L,
      -4958475521373389720L,
      -3920040866770853183L,
      -4755577245976293940L
    )

  "xoroshiro128::next()" should "calculate the right sequence of numbers for a seed of -8884722907433852130, 8146936488925077760" in
    checkSequence(-8884722907433852130L, 8146936488925077760L)(
      -737786418508774370L,
      6831977746526376659L,
      -734363475961070821L,
      3788769925105748835L,
      3799516942461692233L,
      8804496836120406215L,
      4502452080417126604L,
      5209256213827142104L,
      -1703926729889892294L,
      -1182984859477871877L,
      -8258912817497329266L,
      5439129394363390135L,
      -2332636081785475949L,
      3894877403224897644L,
      4134836962150761698L,
      -4211433016749793336L,
      -7811640793330326446L,
      -8425551450224688233L,
      -2263292161856299489L,
      4461705904392488931L
    )

  "xoroshiro128::next()" should "calculate the right sequence of numbers for a seed of -3257375370828617351, -8531679432501196045" in
    checkSequence(-3257375370828617351L, -8531679432501196045L)(
      6657689270379738220L,
      9222059235171711446L,
      -4201421472743020540L,
      -1739444642814636745L,
      -4973628781447893868L,
      2949181541447815382L,
      1026652562213478519L,
      7697981051981754047L,
      -5336402384342581149L,
      -1668375935023408037L,
      4890366791825267198L,
      6451536666718856816L,
      948536817248600930L,
      -4696574786751313290L,
      5504654956598266192L,
      -4872348553376800030L,
      4123719448275272283L,
      -9077443904670060386L,
      3174136521224631338L,
      -1292006535315758191L
    )

  "xoroshiro128::next()" should "calculate the right sequence of numbers for a seed of 9097977738086587765, 3108145906336681618" in
    checkSequence(9097977738086587765L, 3108145906336681618L)(
      -6240620429286282233L,
      2267394554003498845L,
      -4852688425837652380L,
      167972505769480039L,
      1359621195529982136L,
      1246879650983237670L,
      6867699725247969716L,
      -654784861732131297L,
      4104952218497892293L,
      -7942884659741072784L,
      -733604084842556135L,
      -685596469640985328L,
      -5625263263866414292L,
      890001196481155838L,
      -2704766674184838333L,
      -7147039749947577753L,
      -7322299218734396026L,
      2284453502422000668L,
      -3635723251788242046L,
      4518012520836113769L
    )

  "xoroshiro128::next()" should "calculate the right sequence of numbers for a seed of -7309683336934465458, 2484182486618374754" in
    checkSequence(-7309683336934465458L, 2484182486618374754L)(
      -4825500850316090704L,
      6727637936987884581L,
      3038070578391046784L,
      3608526543373619137L,
      -2570440528851677431L,
      -3486267192874186600L,
      -5765880127275252188L,
      5837093774754120939L,
      2788900921353569322L,
      6387034569474398275L,
      5381503650835844894L,
      2374988773823429462L,
      -8528864665156310533L,
      1978884599989166701L,
      888761003258314467L,
      2541457442086701700L,
      -8224173321358362540L,
      -5561700290344507424L,
      -7520354970005942974L,
      3156150446074668489L
    )
}
