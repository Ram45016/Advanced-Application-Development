import '../../assets/css/VenuePage.css'; 
import img from '../../assets/images/banquet.jpg'
import img1 from '../../assets/images/auditorium.jpg';
import img2 from '../../assets/images/banquet.jpg'

function VenuePage(){
  return (
    <div className="venue-container">
      <h2>Choose Your Venue</h2>
      <div className="venue-list">
        <div className="venue-card">
          <img src={img} alt="Open Hall" />
          <h3>Open Hall</h3>
        </div>
        <div className="venue-card">
          <img src={img1} alt="Auditorium" />
          <h3>Auditorium</h3>
        </div>
        <div className="venue-card">
          <img src={img2} alt="Banquet Hall" />
          <h3>Banquet Hall</h3>
        </div>
        {/* Add more venue cards here */}
      </div>
    </div>
  );
}

export default VenuePage;