const video = document.querySelector("#video");
const canvas = document.querySelector("#canvas");
const captureButton = document.querySelector("#capture-button");

// get access to camera
navigator.mediaDevices
  .getUserMedia({ video: true })
  .then((stream) => {
    video.srcObject = stream;
    video.play();
  })
  .catch((err) => {
    console.error(`Error: ${err}`);
  });

// take photo
captureButton.addEventListener("click", () => {
  const context = canvas.getContext("2d");
  context.drawImage(video, 0, 0, canvas.width, canvas.height);
  const data = canvas.toDataURL("image/png");

  // create a link to download the image
  const link = document.createElement("a");
  link.href = data;
  const date = new Date();
  const formattedDate = date.toLocaleString("en-GB", {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    hour12: false,
    hourCycle: "h23",
  });
  link.download = `photo${formattedDate}.png`;
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
});
