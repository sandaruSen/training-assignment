package it.codegen.assignment.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ContractRoomId implements Serializable
{

	@Column(name = "CONTRACT_ID")
	private int contractId;

	@Column(name = "ROOM_ID")
	private int roomId;

	public ContractRoomId() {
	}

	public ContractRoomId(int contractId, int roomId) {
		this.contractId = contractId;
		this.roomId = roomId;
	}
	public int getContractId()
	{
		return contractId;
	}

	public int getRoomId()
	{
		return roomId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getContractId(),getRoomId());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ContractRoomId)) return false;
		ContractRoomId that = (ContractRoomId ) o;
		return Objects.equals(getContractId(), that.getContractId()) &&
				Objects.equals(getRoomId(), that.getRoomId());
	}
}
