
import React from 'react'

class Carousel extends React.Component {

  render() {
    return (
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>

        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-100" src="https://image.ibb.co/dHEizf/IQSK3570.jpg" style={{width: '100%', height: '500px'}} />
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="https://image.ibb.co/mUWkC0/2560-11-06-05-29-16-004.jpg" style={{width: '100%', height: '500px'}} />
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="https://image.ibb.co/mCXE5L/banner-onfront02-03.jpg" style={{width: '100%', height: '500px'}} />
          </div>
        </div>

        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>
    )
  }

}
export default Carousel