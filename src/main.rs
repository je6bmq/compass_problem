use std::f32;
fn compass(l:f32,m:f32,theta:f32,n:f32,o:f32,phi:f32) -> f32 {
    if m<=0.0 
    {
        phi
    }
    else
    {
        let delta_phi=2.0*f32::consts::PI/1000 as f32;
        let ratio=o / n;

        let radius=(l.powi(2)+m.powi(2)-2.0*l*m*(theta.cos())).sqrt();
        let exhaust=radius*delta_phi*ratio;

        compass(l,m-exhaust,theta,n,o,phi+delta_phi)
    }
    
}
fn main() {
    let n=0.001f32;
    let o=0.001f32;
    let theta=2.0*f32::consts::PI/3.0f32;
    let l=1.0f32;
    let m0=1.0f32;

    let analysis=|needle:f32,carbon:f32,rad:f32,unitlen:f32,unitexh:f32|{
        let r0=(needle.powi(2)+carbon.powi(2)-2.0*needle*carbon*(rad.cos())).sqrt();
        (unitlen/unitexh)*(needle*(1.0+rad.cos())/(needle*(rad.cos())-carbon+r0)).ln()
    };
    println!("analysis:{}",analysis(l,m0,theta,n,o));
    println!("simulation:{}",compass(l,m0,theta,n,o,0.0));
}
