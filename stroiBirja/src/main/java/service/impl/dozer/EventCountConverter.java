package service.impl.dozer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerConverter;

@SuppressWarnings("rawtypes")
public class EventCountConverter extends DozerConverter<List, Integer> {

	public EventCountConverter() {
		super(List.class, Integer.class);
	}

	@Override
	public Integer convertTo(List source, Integer destination) {
		Integer eventCount = source.size();
		return eventCount;
	}

	@Override
	public List convertFrom(Integer source, List destination) {
		return new ArrayList<>();
	}
}
