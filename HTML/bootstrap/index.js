$(document).ready(function() {
    $('.card').addClass('animate');
  });
  
// Get the div element
const gallery = document.getElementById('image-gallery');

// Fetch the list of image file names from the server
fetch('assets/images/logo/')
  .then(response => response.text())
  .then(data => {
    // Extract the image file names from the server response
    const imageNames = data.split('\n').filter(fileName => fileName !== '');

    // Loop through the array and generate HTML code for each image
    imageNames.forEach((imageName) => {
      // Create a div element for the image
      const div = document.createElement('div');
      div.className = 'col';
      const img = new Image();
      img.src = `assets/images/logo/${imageName}`;
      img.addEventListener('load', () => {
        div.innerHTML = `
          <div class="card h-100">
            <img src="${img.src}" class="card-img-top">
            <div class="card-body position-relative">
              <p class="card-text">${imageName.split('.')[0]}</p>
            </div>
          </div>
        `;
        gallery.appendChild(div);
      });
      img.addEventListener('error', () => {
        console.error(`Failed to load image: ${img.src}`);
      });
    });
  })
  .catch(error => console.error(error));





