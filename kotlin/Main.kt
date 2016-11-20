import java.lang.Math;
object MainKt {
    tailrec fun compass(l:Double,m:Double,theta:Double,n:Double,o:Double,phi:Double=0.0):Double= 
    if(m<=0)
    {
            phi
    }
    else
    {
            val delta_phi=2.0*Math.PI/10000000
            val ratio=o/n
            val radius=Math.sqrt(Math.pow(l,2.0)+Math.pow(m,2.0)-2.0*l*m*Math.cos(theta))
            val exhaust=radius*delta_phi*ratio

            compass(l,m-exhaust,theta,n,o,phi+delta_phi)
    }
    
  @JvmStatic fun main(args:Array<String>) {
      val n=0.001
      val o=0.001
      val theta=2.0*Math.PI/3
      val l=1.0
      val m0=1.0

      val analysis={
          needle:Double,carbon:Double,rad:Double,unitlen:Double,unitexh:Double->
          val r0=Math.sqrt(Math.pow(needle,2.0)+Math.pow(carbon,2.0)-2.0*needle*carbon*Math.cos(rad))
          (unitlen/unitexh)*Math.log(needle*(1.0+Math.cos(rad))/(needle*(Math.cos(rad)-carbon+r0)))
          }

      println("analysis:${analysis(l,m0,theta,n,o)}")    
      println("simulation:${compass(l,m0,theta,n,o)}")
  }
}
