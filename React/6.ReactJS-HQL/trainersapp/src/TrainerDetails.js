// src/TrainerDetails.js
import { useParams } from "react-router-dom";
import trainersMock from "./TrainersMock";

function TrainerDetail() {
  const { id } = useParams();
  const trainer = trainersMock.find(t => t.trainerId === id);

  if (!trainer) return <p>Trainer not found.</p>;

  return (
    <div>
      <h2>{trainer.name}</h2>
      <p><strong>Email:</strong> {trainer.email}</p>
      <p><strong>Phone:</strong> {trainer.phone}</p>
      <p><strong>Technology:</strong> {trainer.technology}</p>
      <p><strong>Skills:</strong> {trainer.skills.join(", ")}</p>
    </div>
  );
}

export default TrainerDetail;
